Feature: Pricing

  @wip
  Scenario: Currencies in Invoice Amount
    Given The user is on the homepage
    And The user navigates to "Pricing" page
    When the user clicks on currency dropdown in Invoice AMount
    Then Currencies should be listed as shown below
      | AUD |
      | CAD |
      | CHF |
      | CZK |
      | DKK |
      | EUR |
      | GBP |
      | HKD |
      | HRK |
      | HUF |
      | JPY |
      | NOK |
      | PLN |
      | RUB |
      | SEK |
      | TRY |
      | USD |

  @wip
  Scenario: Currencies in Pay Out Method
    Given The user is on the homepage
    And The user navigates to "Pricing" page
    When the user clicks on currency dropdown in Pay Out Method
    Then Currencies should be listed as shown below
      | USD - Outside US   |
      | USD - US Only      |
      | EUR (SEPA)         |
      | EUR (outside SEPA) |
      | AED                |
      | ARS                |
      | AUD                |
      | BDT                |
      | BGN                |
      | BRL                |
      | CAD                |
      | CHF                |
      | CLP                |
      | CNY                |
      | COP                |
      | CZK                |
      | DKK                |
      | EGP                |
      | GBP                |
      | GEL                |
      | HKD                |
      | HRK                |
      | HUF                |
      | IDR                |
      | ILS                |
      | INR                |
      | JPY                |
      | KES                |
      | KRW                |
      | LKR                |
      | MAD                |
      | MXN                |
      | MYR                |
      | NGN                |
      | NOK                |
      | NZD                |
      | PEN                |
      | PHP                |
      | PKR                |
      | PLN                |
      | RON                |
      | RUB                |
      | SEK                |
      | SGD                |
      | THB                |
      | TRY                |
      | TZS                |
      | UAH                |
      | UGX                |
      | VND                |
      | ZAR                |


  @wip
  Scenario: Calculate your fee
    Given The user is on the homepage
    And The user navigates to "Pricing" page
    When The user selects "USD" from Invoice Amount
    And The user type "5000.00"
    And The user selects "BDT" from Payout Method
    Then Applied rate is "6.5%"
    And the user gets "401.436,54" in "BDT"



    Scenario: test
      Given test

