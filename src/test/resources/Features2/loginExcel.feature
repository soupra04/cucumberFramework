Feature: Login Test from Excel

Scenario Outline: login scnearios with diff data set

		  Given Open this Page "https://practicetestautomation.com/practice-test-login/"
		  When user fills form from sheetname "<SheetName>" and rownumber <RowNumber>
		  And I click the submit button
		  Then  I should see this message "Logged In Successfully"


Examples:
|SheetName|RowNumber|
|loginPage|0|
|loginPage|1|
