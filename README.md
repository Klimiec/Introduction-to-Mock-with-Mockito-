# Introduction to mocking/stubbing with Mockito

The Purpose of this project is an introduction to less common features of Mockito framework and test templates in IntelliJ IDEA. 

I will start with fundamental things of mocking/stubbing in order to lay the ground for more advanced things. They will help us highlights problems we encounter on daily bases when working with Mockito and embraces solutions :-) 

***Agenda***
* [Default behaviour of not stubbed method](#default-behaviour-of-not-stubbed-method)
* [SmartNulls](#smartnulls)
* [Mockito global configuration ](#mockito-global-configuration)
* [Deep stubbing](#deep-stubbing)
* [Templates in intelliJ ](#templates-in-intelliJ)


### Default behaviour of not stubbed method

When no stubbed, methods of mocks return zeros, falseys, empty collections or nulls - depends what is the return type of used method. It can lead to encountering NullPointerException. 

```text
java.lang.NullPointerException
    at domain.ItemService.issueInvoice(ItemService.java:10)
    at domain.a_missing_mock_for_organisation.ItemServiceTest.shouldIssueAnInvoiceWithSuccess(ItemServiceTest.java:24)
```
Code example [here](xyz)

Above stack trace informes us only about the line number where NullPointerException occurred. It isn’t obvious at first glance that the source of the problem was default value returned from unstubbed method that developer has forgotten to stub. What if we could get a more readable stack trace that help us track the bug right away. It turns out that Mockito has such feature - SmartNull. 


### SmartNulls

SmartNull produces much more descriptive exception message then NPE. 
It points exactly what unstubbed method on mock was called that lead to NPE. 

```text
org.mockito.exceptions.verification.SmartNullPointerException: 
You have a NullPointerException here:
-> at domain.ItemService.issueInvoice(ItemService.java:10)
because this method call was *not* stubbed correctly:
-> at domain.ItemService.issueInvoice(ItemService.java:10)
item.getOrganisation();


	at domain.ItemService.issueInvoice(ItemService.java:10)
	at domain.b_smart_null.ItemServiceTest.shouldIssueAnInvoiceWithSuccess(ItemServiceTest.java:28)
```
Code example [here](xyz)

To make mock returns SmartNull instead of null override default answer with RETURNS_SMART_NULLS flag

```java
mock(Item.class, RETURNS_SMART_NULLS);
```
or 

```java
@Mock(answer = Answers.RETURNS_SMART_NULLS)
Item item;
```
We need to change default answer for every mock that we want to return smart nulls. Because of this ceremony not many people opt to use this feature. 

It turns out that with a little work we can change default answer for all mock to RETURNS_SMART_NULLS with no additional repetitive work.


### Mockito global configuration 

Mockito provides a global configuration that we can use to change some default behavior. For instance, we can change default answer for unstubbed mock to RETURNS_SMART_NULLS.

In order to do this, we need to create class org.mockito.configuration.MockitoConfiguration (in test folder) that extends DefaultMockitoConfiguration.

```java
public class MockitoConfiguration extends DefaultMockitoConfiguration{

    public Answer<Object> getDefaultAnswer() {
        return new ReturnsSmartNulls();
    }
}
```
Code example [here](xyz)

### Deep stubbing

Sometimes when working with a badly design legacy system we encounter a situation where in order to tests something our mock has to return another mock to return something meaningful. 

Example of ‘deep stubbing’ 

```java
        Item item = mock(Item.class, RETURNS_SMART_NULLS);
        Organisation organisation = mock(Organisation.class);

        when(item.getOrganisation()).thenReturn(organisation);
        when(organisation.getOrganisationId()).thenReturn(0l);
```

We can shorten deep stubbing creation with RETURNS_DEEP_STUBS

```java
        Item item = mock(Item.class, RETURNS_DEEP_STUBS);
        when(item.getOrganisation().getOrganisationId()).thenReturn(0l);
```

More information [here](https://static.javadoc.io/org.mockito/mockito-core/1.10.19/org/mockito/Mockito.html#RETURNS_DEEP_STUBS)

### Templates in intelliJ 

IntelliJ provides templates for test methods and test classes.
They are very helpfull in getting ride of repetive task such as: 
- add static import for Mockito and AssertJ 
- embeding comments for 'given-when-then' inside test method 


##### Test method #####

In order to edit template for test method go to File | Settings | Editor | File and Code Templates. 
Choose 'code' tab and edit JUnit4 Test Method with following values. 

```java
@org.junit.Test
public void should${NAME}() {
  //given
  ${BODY}
  //when
  //then
}
```
To use template press Cltr + Insert inside test class and choose Test Method.

##### Test class #####

In order to edit template for test class go to File | Settings | Editor | File and Code Templates. 

```java
import static org.assertj.core.api.WithAssertions.*;
import static org.mockito.BDDMockito.*;

#parse("File Header.java") 
public class ${NAME} {
  ${BODY}
}    
```
To use template press Ctrl + Shift + T inside class and pick Create New Test ...







