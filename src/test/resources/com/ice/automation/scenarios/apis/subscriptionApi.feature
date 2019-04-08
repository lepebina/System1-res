#@Api
#  Feature: Subscriptions Api
#    Background: Clear subscription configuration
#      Given There is no subscription configured in the system
#
#    Scenario: Subscriptions create configuration
#      Given Create subscription "" starts on "" and ends on "" with "" free days and no welcome message from billed shorcode
#      Given Create subscription "" starts on "" and ends on "" with "" free days and no welcome message from free shorcode
#      Given Create subscription "" starts on "" and ends on "" with "" free days and welcome message from billed shorcode
#      Given Create subscription "" starts on "" and ends on "" with "" free days and welcome message from free shorcode
#      Given Edit subscription "" starts on "" and ends on "" with "" free days and no welcome message from billed shorcode
#      Given Edit subscription "" starts on "" and ends on "" with "" free days and no welcome message from free shorcode
#      Given Edit subscription "" starts on "" and ends on "" with "" free days and welcome message from billed shorcode
#      Given Edit subscription "" starts on "" and ends on "" with "" free days and welcome message from free shorcode
#      And User belongs to "" subscription service
#
#      Then User should receive "<string>" content reply
#      Then User receives the "<string>" reply from billed short code
