@Subscription_Multiple
Feature: Multiple Subscriptions test cases

  Background: Setup
    Given Sms free short code is "55577"
    Given Sms free subscription short code is "55588"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Refresh cache


  Scenario: User multiple with profile sends optin keyword with active subscription with free week
    Given User has "355066712002" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | response_type        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1                   | SUBSCRIPTION_CONTENT |
    Given Sms free short code is "55578"
    And User sends sms with input "YES" to free short code
    Then User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                   | response_type        |
      | PersonalitySubscription2Welcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1                    | SUBSCRIPTION_CONTENT |

  Scenario: User multiple with profile sends optin keyword with active subscription with free week
    Given User has "355066989802" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | response_type        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1                   | SUBSCRIPTION_CONTENT |
    And User sends sms with input "YES1" to free short code
    Then User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                   | response_type        |
      | PersonalitySubscription2Welcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1                    | SUBSCRIPTION_CONTENT |

