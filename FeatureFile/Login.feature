Feature: Validation of Login functionality
@tag1
Scenario: Login functionality validation1
When I login into stockAccounting Url on Chrome Browser
When I click Reset Button on Login Page
And I enter admin and masterin UserNameField and PasswordField
When I click on Login Button
When I wait for LogoutLink
Then I validate the title of the home page and close the Browser