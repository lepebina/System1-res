#@Keywords
#Feature: Keywords
#
#  Scenario: keyword setup
#    Given Keyword "SUB_IN"" has the following details:
#  | service | subscription |
#  | subscriptionOptinKeywordHandler    | JUnit_Subscription         |
#    And Keyword "HELP" has the below aliases:
#      | alias | regex     |
#      | IN    | [I1LlnN]+ |
#    And Keyword  "HELP" has the below configuration:
#      | operator      | countrycode | shortcode |
#      | Test_Operator | AL          | 1234      |
#
#    When Keyword "SUB_IN" is created
#    Then Keyword "SUB_IN" is configured