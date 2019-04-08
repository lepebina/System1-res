@Flow
Feature: Subscription flow test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Sms free subscription short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

  @original-flow-1
  Scenario: Subscribed user plays with active game
    Given User has "355002033000" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | text_response        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1-full              | SUBSCRIPTION_CONTENT |
    And User does not get charged for the sms
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                     | text_response   |
      | PersonalityQuizPool.1.1-ans  | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.2-full | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                     | text_response   |
      | PersonalityQuizPool.1.2-ans  | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.3-full | DIALOG_CTA      |
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                     | text_response   |
      | PersonalityQuizPool.1.3-ans  | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.4-full | DIALOG_CTA      |
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                     | text_response   |
      | PersonalityQuizPool.1.4-ans  | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.5-full | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply

  @original-flow-2
  Scenario: Subscribed user plays and send keywords also with active game
    Given User has "355002033001" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | text_response        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1-full              | SUBSCRIPTION_CONTENT |
    And User does not get charged for the sms
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.1-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.2     | DIALOG_CTA      |
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.2-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.3     | DIALOG_CTA      |
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.3-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.4     | DIALOG_CTA      |
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.4-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.5     | DIALOG_CTA      |
    When User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_HELP" request
    And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
    When User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_SCORE" request
    And User receives the "subscription_1_score" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply

  @original-flow-3
  Scenario: Subscribed user plays with active game and also sends optout keyword
    Given User has "355002033007" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | text_response        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1-full              | SUBSCRIPTION_CONTENT |
    And User does not get charged for the sms
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.1-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.2     | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.2-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.3     | DIALOG_CTA      |
    When User sends sms with input "STOP" to free short code
    And User sends sms with input "YES" to free short code
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.3-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.4     | DIALOG_CTA      |
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.4-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.5     | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply

  @original-flow-4
  Scenario: Subscribed user plays without active game
    Given User has "355002033002" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And User has played today's game
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply

  @original-flow-5
  Scenario: Subscribed user plays and sends keywords also without active game
    Given User has "355002033003" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And User has played today's game
    When User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_SCORE" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the "subscription_1_score" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    When User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_HELP" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

  @original-flow-6
  Scenario: Subscribed user plays and sends STOP keyword also without active game
    Given User has "355002033004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And User has played today's game
    When User sends sms with input "STOP" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    And User does not get charged for the sms

  @original-flow-7
  Scenario: Subscribed user plays,send keywords and sends optout also with active game
    Given User has "355002033005" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "SUBSCRIBE" request
    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                                  | text_response        |
      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
      | PersonalityQuizPool.1.1-full              | SUBSCRIPTION_CONTENT |
    And User does not get charged for the sms
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.1-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.2     | DIALOG_CTA      |
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.2-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.3     | DIALOG_CTA      |
    When User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_HELP" request
    And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.3-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.4     | DIALOG_CTA      |
    When User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_SCORE" request
    And User receives the "subscription_1_score" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    When User sends sms with input "STOP" to free short code
    When User sends sms with input "YES" to free short code
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                    | text_response   |
      | PersonalityQuizPool.1.4-ans | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.5     | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the "no_navigation" text from free short code for "NO_NAVIGATION" reply