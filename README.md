# Airspace

// we can execute the script by running a maven commant form the terminal:
//mvn clean test -DcucumberOptions="-tags @regression"

Note:
To test run a regression a tester should have also the ‘Business Requirement” document to base his validation.
Eexample: min or max length of username and password, accepted characters, escaped characters, emails or usernames etc..

For the purpose of this testing I assumed that some rules are already set, but there are some concerns to be raised, for example:
For security purpose is not good practice to display an alert with specific failure like”Your username is invalid!”
instead could display like ”Your username or password is invalid!” .  The same scenario for the password too.


// There will be a test failure in this regression for the below Scenario:
// Scenario: User should not be able to re-enter in the Secure Page by pressing ‘Back arrow’ once is loged out


I am sure that there are more tests to be performed (like in different browsers and platformes, etc) but here are some functionalities checked

Total: 105 Scenarios (1 failed, 104 passed)
322 Steps (1 failed, 321 passed)

Here you will find a youtube video recording(11 min long) Url that displaying the successfully tests run:
https://youtu.be/Sw_XsMXwYRc

Here is the Github Url repository where the QA team can clone it: https://github.com/ilirahmetiqa/Airspace