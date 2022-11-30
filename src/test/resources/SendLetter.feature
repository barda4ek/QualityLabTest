Feature: Send letter feature

  Scenario: Send new letter via mail.ru, checking if it has actually sent
    Given I am on the Mail.ru Page
    When I login to my account as krasilnikovqualitylab@mail.ru with password quality1395
    And I click Compose new letter
    And I fill theme with randomKey
    And I fill destination address: chvvplrzmbutmfzfzj@tmmcv.com
    And I fill message body and send.
    Then  I check message "Сообщение отправлено"
    And I check if the last sent letter's theme is equal to Expected