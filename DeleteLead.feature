Feature: Login to Leaftaps application

Background:
Given Launch Chrome Browser
When Load URL 'https://leaftaps.com/opentaps'
And type username as 'DemoSalesManager'
And type password as 'crmsfa'
And Click Login button
Then Click on Leads

Scenario Outline:
When Click on Find Leads
And Enter First Name as <Fname>
And Click on Find Leads Button
And Click on the first result
And Click on Delete button


Examples:
|Fname|
|'Jananee'|
|'Supraja'|

