@Flow
Feature: Personality flow test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Sms free subscription short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

  Scenario: Subscribed user sends more "1" replies
    Given User has "355002044000" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When User sends sms with input "1" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "3" to free short code
    When User sends sms with input "1" to free short code
    When User sends sms with input "1" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
#    And User receives the following text content from free short code ordered by event time:
#      | text_key                      | text_content                                                                                                                                                                                                                                                                                                                   |
#      | PersonalityQuizPool.1.5-ans   | 100% completed! Please wait while we find your ideal kind of comedy!                                                                                                                                                                                                                                                           |
#      | PersonalityQuizEndOfSession.1 | Your personality match: You are a romantic comedy! Laughing is good, but it gets better when you do it with someone you love! Sentimental and cute, you live your life with an emphasis on relationships and optimism: despite all misunderstandings, it always works out for the best! Another fun test will arrive tomorrow! |

  Scenario: Subscribed user sends more "2" replies
    Given User has "355002044001" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When User sends sms with input "1" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "3" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "2" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
#    And User receives the following text content from free short code ordered by event time:
#      | text_key                      | text_content                                                                                                                                                                                                                                                                                                                  |
#      | PersonalityQuizPool.1.5-ans   | 100% completed! Please wait while we find your ideal kind of comedy!                                                                                                                                                                                                                                                          |
#      | PersonalityQuizEndOfSession.1 | Your personality match: You are a teen comedy! Why just smile when you can laugh your head off? Young at heart and fond of any kind of jokes, even the ones directed at you, you don't take things seriously and hate pomposity. You speak your mind and never hide behind nice words! Another fun test will arrive tomorrow! |

  Scenario: Subscribed user sends more "3" replies
    Given User has "355002044002" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When User sends sms with input "1" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "3" to free short code
    When User sends sms with input "3" to free short code
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
#    And User receives the following text content from free short code ordered by event time:
#      | text_key                      | text_content                                                                                                                                                                                                                                                                                                                  |
#      | PersonalityQuizPool.1.5-ans   | 100% completed! Please wait while we find your ideal kind of comedy!                                                                                                                                                                                                                                                          |
#      | PersonalityQuizEndOfSession.1 | Your personality match: You are a parody! You are unique and hip and not everyone understands your sense of humor, or your whole way of thinking for that matter. Nevermind: you have unusual friends who think like you do and, when you are together, you will make fun of anything! Another fun test will arrive tomorrow! |

  Scenario: Subscribed user sends same amount of replies
    Given User has "355002044003" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When User sends sms with input "1" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "1" to free short code
    When User sends sms with input "2" to free short code
    When User sends sms with input "3" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key                      | text_response   |
      | PersonalityQuizPool.1.5-ans   | DIALOG_RESPONSE |
      | PersonalityQuizEndOfSession.1 | DIALOG_CTA      |
#    And User receives the following text content from free short code ordered by event time:
#      | text_key                      | text_content                                                                                                                                                                                                                                                                                                                     |
#      | PersonalityQuizPool.1.5-ans   | 100% completed! Please wait while we find your ideal kind of comedy!                                                                                                                                                                                                                                                             |
#      | PersonalityQuizEndOfSession.1 | Your personality match: You are a dark comedy! A joke mustn't only make you laugh: it must also make you think about serious stuff, like our nature or our place in the universe. Nevertheless, you are one of the funniest people around, exactly because nothing stops you from joking! Another fun test will arrive tomorrow! |