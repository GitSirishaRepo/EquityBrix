Feature:  Login Page Feature

  Scenario: Validate Page Title
    Given user is on Investor Login page
    And wait for page to load
    Then page title should be "Sign in"

  Scenario Outline: Login successful
    Given user is on Investor Login page
    And wait for page to load
    When enter username <string> and password <string2>
    When click on Sign in button
    Examples:
      | string                            | string2         |
      | "bhargavi.sponsor+qa26@gmail.com" | "Lsnworks@2022" |

    Scenario: Sign/Create Investor Successful

      Given user is on Investor Login page
      And wait for page to load
      When user clicks on Sign in link
      And enters email clicks send verification button
      And waits for some time
      When opt is received and enters otp
      And waits for some time
      And clicks verify button
