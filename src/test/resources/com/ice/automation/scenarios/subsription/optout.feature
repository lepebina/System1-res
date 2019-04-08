@Subscription_Optout
Feature: Subscription Opt-out test cases

	Background: Setup
		Given Sms free short code is "55577"
		And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "7" free days and welcome message from free shorcode

  # active subscription
	Scenario:No profile customer sends optout keyword with active subscription
		Given User has "355004567821" msisdn
		And User has no profile
		When User sends sms with input "STOP" to free short code
		Then User has profile
		And User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_already_unsubscribed" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms

	Scenario:Subscribed user sends optout keyword with active subscription
		Given User has "355004567822" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms

	Scenario:Subscribed user sends optout keyword alias with active subscription
		Given User has "355004567822" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "QUIT" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms

	Scenario:Subscribed user sends optout keyword alias (regex) with active subscription
		Given User has "355004567822" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "HellOAndoFfTbarboutsala" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms

	Scenario:Unsubscribed user sends optout keyword with active subscription
		Given User has "355004567823" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_already_unsubscribed" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms

	Scenario:Blacklisted user sends optout keyword with active subscription
		Given User has "355004567824" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		When User is blacklisted
		And User sends sms with input "STOP" to free short code
		Then User has subscription profile
		And Sms is being processed by the "BLACKLISTED" request
		And User receives the "BLACKLISTED" reply from free short code
		And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
		And User does not get charged for the sms
		And User is not blacklisted

	Scenario: Unsubscribed user sends HELP keyword with active subscription
		Given User has "355004567825" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "HELP" to free short code
		And Sms is being processed by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

	Scenario: Unsubscribed user sends SCORE keyword with active subscription
		Given User has "355004567826" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "SCORE" to free short code
		And Sms is being processed by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

	Scenario: Unsubscribed user sends YES keyword with active subscription
		Given User has "355004567827" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "YES" to free short code
		And Sms is being processed by the "ACTIVITY" request
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key                                  | response_type        |
			| PersonalitySubscriptionWelcome.MESSAGES.3 | SUBSCRIPTION_WELCOME |
			| PersonalityQuizPool.1.1-invalid           | DIALOG_RESPONSE      |
			| PersonalityQuizPool.1.1-full              | DIALOG_CTA           |

	Scenario: Unsubscribed user sends anything with active subscription
		Given User has "355004567828" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "ANYTHING" to free short code
		And Sms is being processed by the "ACTIVITY" request
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key                                | response_type        |
			| PersonalitySubscriptionWelcome.MESSAGES | SUBSCRIPTION_WELCOME |
			| PersonalityQuizPool.1.1-invalid         | DIALOG_RESPONSE      |
			| PersonalityQuizPool.1.1                 | DIALOG_CTA           |

	Scenario: Unsubscribed user sends "1" with active subscription
		Given User has "355004567840" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "1" to free short code
		Then Sms is being processed by the "UNSUBSCRIBED" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

	Scenario: Unsubscribed user sends "2" with active subscription
		Given User has "355004567841" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When User sends sms with input "2" to free short code
		Then Sms is being processed by the "UNSUBSCRIBED" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply


  #inactive subscription
	Scenario:No profile customer sends optout keyword with no active subscription
		Given User has "355004567831" msisdn
		And User has no profile
		And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "STOP" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario:Subscribed user sends optout keyword with no active subscription
		Given User has "355004567832" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "STOP" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario:Unsubscribed user sends optout keyword with no active subscription
		Given User has "355004567833" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		And Sms is being processed by the "UNSUBSCRIBE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_unsubscribe" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		And User does not get charged for the sms
		And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "STOP" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario:Blacklisted user sends optout keyword with no active subscription
		Given User has "355004567834" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		When User is blacklisted
		And Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		And User sends sms with input "STOP" to free short code
		Then User has subscription profile
		Then Sms is being processed by the "BLACKLISTED" request
		And User receives the "BLACKLISTED" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key             | response_type |
			| text_key_blacklisted | BLACKLISTED   |
		And User is blacklisted

	Scenario: Unsubscribed user sends HELP keyword with no active subscription
		Given User has "355004567835" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "HELP" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario: Unsubscribed user sends SCORE keyword with no active subscription
		Given User has "355004567836" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "SCORE" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario: Unsubscribed user sends YES keyword with no active subscription
		Given User has "355004567837" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "YES" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario: Unsubscribed user sends anything with no active subscription
		Given User has "355004567838" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "ANYTHING" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario: Unsubscribed user sends "1" with no active subscription
		Given User has "355004567845" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2016 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "1" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario: Unsubscribed user sends "2" with no active subscription
		Given User has "355004567846" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has subscription profile
		When User sends sms with input "STOP" to free short code
		Then User is unsubscribed in subscription profile
		When Inactive subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2016 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		When User sends sms with input "2" to free short code
		Then Sms is being processed by the "INVALID_REQUEST" request
		And User receives the "INVALID_REQUEST" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key        | response_type   |
			| invalid_request | INVALID_REQUEST |

	Scenario:Subscribed user sends optout keyword with active subscription which starts in the future
		Given User has "355004567100" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2018 00:00:00" and ends on "01/01/2019 00:00:00" with "7" free days and welcome message from free shorcode
		And Refresh cache
		And User sends sms with input "STOP" to free short code
		Then User has subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key                  | response_type                 |
			| subscription_1_pre_launch | RESPONSE_SUBSCRIPTION_SERVICE |

	Scenario:Subscribed user sends optout keyword with active subscription which has expired
		Given User has "355004567101" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2010 00:00:00" and ends on "01/01/2014 00:00:00" with "7" free days and welcome message from free shorcode
		And Refresh cache
		And User sends sms with input "STOP" to free short code
		Then User has subscription profile
		And Sms is being processed by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the following texts/response types from free short code ordered by event time:
			| text_key               | response_type                 |
			| subscription_1_invalid | RESPONSE_SUBSCRIPTION_SERVICE |



