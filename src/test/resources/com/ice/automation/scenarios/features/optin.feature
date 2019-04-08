@Subscription_Optin
Feature: Subscription Opt-in test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "7" free days and welcome message from free shorcode
    And Refresh cache

@original-optin-1
  Scenario: User with no profile sends optin keyword with active subscription with free week
    Given User has "355006712001" msisdn
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

  @original-optin-2
  Scenario: A User with profile sends optin keyword with active subscription with free week
    Given User has "355006712002" msisdn
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
    When User sends sms with input "YES" to free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                        | response_type   |
      | PersonalityQuizPool.1.1-invalid | DIALOG_RESPONSE |
      | PersonalityQuizPool.1.1         | DIALOG_CTA      |

#  Scenario:User with no profile sends optin keyword with active subscription with no free week
#    Given User has "355006712003" msisdn
#    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
#    And Refresh cache
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    And Sms is being processed by the "SUBSCRIBE" request
#    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
#    And User receives the following texts/response types from free short code ordered by event time:
#      | text_key                                | response_type        |
#      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
#      | PersonalityQuizPool.1.1                 | SUBSCRIPTION_CONTENT |

#  Scenario:User with profile sends optin keyword with active subscription with no free week
#    Given User has "355006712004" msisdn
#    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
#    And Refresh cache
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    And Sms is being processed by the "SUBSCRIBE" request
#    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
#    And User receives the following texts/response types from free short code ordered by event time:
#      | text_key                                | response_type        |
#      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
#      | PersonalityQuizPool.1.1                 | SUBSCRIPTION_CONTENT |
#    When User sends sms with input "YES" to free short code
#    And User receives the following texts/response types from free short code ordered by event time:
#      | text_key        | response_type |
#      | PersonalityQuizPool.1.1-invalid | DIALOG_RESPONSE       |
#      | PersonalityQuizPool.1.1 | DIALOG_CTA       |

  @original-optin-3
  Scenario: User with no profile sends optin keyword with no active subscription
    Given User has "355006712005" msisdn
    And User has no profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has no subscription profile
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key        | response_type   |
      | invalid_request | INVALID_REQUEST |

  @original-optin-4
  Scenario: User with profile sends optin keyword with no active subscription
    Given User has "355006712006" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User sends sms with input "YES" to free short code
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key        | response_type   |
      | invalid_request | INVALID_REQUEST |

  @original-optin-5
  Scenario: User with profile sends optin keyword with active subscription with free week without active game
    Given User has "355006712007" msisdn
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
    When User has played today's game
    And User sends sms with input "YES" to free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key      | response_type |
      | no_navigation | NO_NAVIGATION |

#  Scenario:User with profile sends optin keyword with active subscription with no free week without active game
#    Given User has "355006712009" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    And Sms is being processed by the "SUBSCRIBE" request
#    And User receives the "SUBSCRIPTION_WELCOME" reply from free short code
#    And User receives the following texts/response types from free short code ordered by event time:
#      | text_key                                | response_type        |
#      | PersonalitySubscriptionWelcome.MESSAGES.1 | SUBSCRIPTION_WELCOME |
#      | PersonalityQuizPool.1.1                 | SUBSCRIPTION_CONTENT |
#    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
#    And Refresh cache
#    And User has played today's game
#    And User sends sms with input "YES" to free short code
#    And User receives the following texts/response types from free short code ordered by event time:
#      | text_key        | response_type |
#      | no_navigation | NO_NAVIGATION       |

  @original-optin-6
  Scenario: Subscribed user sends with active game with no active subscription HELP keyword
    Given User has "355006712010" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the "invalid_request" text from free short code for "INVALID_REQUEST" reply
    And User does not get charged for the sms

 @original-optin-7
  Scenario: Subscribed user sends without active game with no active subscription HELP keyword
    Given User has "355006712011" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    And User has played today's game
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the "invalid_request" text from free short code for "INVALID_REQUEST" reply
    And User does not get charged for the sms

  @original-optin-8
  Scenario: Subscribed user sends with active game with no active subscription SCORE keyword
    Given User has "355006712012" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the "invalid_request" text from free short code for "INVALID_REQUEST" reply
    And User does not get charged for the sms

  @original-optin-9
  Scenario: Subscribed user sends without active game with no active subscription SCORE keyword
    Given User has "355006712013" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    And User has played today's game
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "INVALID_REQUEST" request
    And User receives the "INVALID_REQUEST" reply from free short code
    And User receives the "invalid_request" text from free short code for "INVALID_REQUEST" reply
    And User does not get charged for the sms

  @original-optin-10
  Scenario: Subscribed blacklisted user sends with active game with no active subscription HELP keyword
    Given User has "355006712014" msisdn
    And User has no profile
    And User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User is blacklisted
    And User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms

@original-optin-11
  Scenario: Subscribed blacklisted user sends without active game with no active subscription HELP keyword
    Given User has "355006712015" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    And User has played today's game
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User is blacklisted
    And User sends sms with input "HELP" to free short code
    Then Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms

  @original-optin-12
  Scenario: Subscribed blacklisted user sends with active game with no active subscription SCORE keyword
    Given User has "355006712016" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User is blacklisted
    And User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms

  @original-optin-13
  Scenario: Subscribed blacklisted user sends without active game with no active subscription SCORE keyword
    Given User has "355006712017" msisdn
    And User has no profile

    And User sends sms with input "YES" to free short code
    And User has played today's game
    Then User has profile
    And User has subscription profile
    And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
    And Refresh cache
    And User is blacklisted
    And User sends sms with input "SCORE" to free short code
    Then Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms

 @original-optin-14
  Scenario: User with profile sends optin keyword with active subscription which starts in the future
    Given User has "355006712018" msisdn
    And User has no profile
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2020 00:00:00" and ends on "01/01/2021 00:00:00" with "7" free days and welcome message from free shorcode
    And Refresh cache
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User is unsubscribed in subscription profile
    And Sms is being processed by the "PRE_LAUNCH" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                  | response_type                 |
      | subscription_1_pre_launch | RESPONSE_SUBSCRIPTION_SERVICE |

#  Scenario:Parked user sends optin keyword with active subscription with free week
#    Given User has "355006710012" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked user sends optin keyword with active subscription with billed week
#    Given User has "355006710012" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked user sends optin keyword with no active subscription
#    Given User has "355006710020" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked user sends optin keyword with no active subscription HELP keyword
#    Given User has "355006710024" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked user sends optin keyword with no active subscription SCORE keyword
#    Given User has "355006710024" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked blacklisted user sends optin keyword with active subscription free week
#    Given User has "355006710016" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked blacklisted user sends optin keyword with active subscription billed week
#    Given User has "355006710016" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked blacklisted user sends optin keyword with no active subscription
#    Given User has "355006710024" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked blacklisted user sends optin keyword with no active subscription HELP keyword
#    Given User has "355006710024" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code
#
#  Scenario:Parked blacklisted user sends optin keyword with no active subscription SCORE keyword
#    Given User has "355006710024" msisdn
#    And User has no profile
#    When User sends sms with input "YES" to free short code
#    Then User has profile
#    And  User is blacklisted
#    And User has subscription profile
#    When User sends sms with input "STOP" to free short code
#    Then User is unsubscribed in subscription profile
#    And Sms is being processed by the "UNSUBSCRIBE" request
#    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
#    And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
#    And User does not get charged for the sms
#    When User sends sms with input "STOP" to free short code

