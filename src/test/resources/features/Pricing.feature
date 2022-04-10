Feature: Pricing

  @wip
  Scenario Outline: Calculate your fee
    Given The user is on the homepage
    And The user navigates to "Pricing" page
    When The user selects "<invCurr>" from Invoice Amount
    And The user type "<invAmount>"
    And The user selects "<payoutCurr>" from Payout Method
    Then Applied rate is "<rate>"
    And the user gets "<paidAmount>" in "<payoutCurr>"

    Examples:
      | invCurr | invAmount | payoutCurr | rate | paidAmount |
      | USD     | 5000.00   | CAD        | 6.5% | 5,875.76   |
      | GBP     | 5000.00   | TRY        | 6.5% | 89.832,70  |
      | CAD     | 5000.00   | TRY        | 6.5% | 54.843,97  |


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



