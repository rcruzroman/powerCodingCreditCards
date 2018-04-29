# powerCodingCreditCards

Coding challenge

Implement a program that determines whether a provided credit card
number is valid according to Luhn’s algorithm.
Background
American Express uses 15-digit numbers, MasterCard uses 16-digit
numbers, and Visa uses 13- and 16-digit numbers. American Express
numbers all start with 34 or 37; MasterCard numbers all start with 51, 52,
53, 54, or 55; and Visa numbers all start with 4. Credit card numbers also
have a "checksum" built into them. According to Luhn’s algorithm, you can
determine if a credit card number is (syntactically) valid as follows:

○ Multiply every other digit by 2, starting with the number’s
second-to-last digit, and then add those products' digits together.

○ Add the sum to the sum of the digits that weren’t multiplied by 2.

○ If the total’s last digit is 0 (or, put more formally, if the total modulo
10 is congruent to 0), the number is valid.

Test

○ American Express: 378282246310005 | 371449635398431
○ Mastercard: 5555555555554444 | 5105105105105100
○ Visa: 4111111111111111 | 4012888888881881

Example

The algorithm would behave like this when checking a test American
Express number: 378282246310005.
Let’s first underline every other digit, starting with the number’s
second-to-last digit:
3 7 8 2 8 2 2 4 6 3 1 0 0 0 5
We multiply each of the underlined digits by 2:
7•2 + 2•2 + 2•2 + 4•2 + 3•2 + 0•2 + 0•2
That gives us:
14 + 4 + 4 + 8 + 6 + 0 + 0
Now let’s add those products' digits together:
1 + 4 + 4 + 4 + 8 + 6 + 0 + 0 = 27
Now let’s add that sum (27) to the sum of the digits that weren’t multiplied
by 2:
27 + 3 + 8 + 8 + 2 + 6 + 1 + 0 + 5 = 60
The last digit in that sum (60) is a 0, so the test card would be legit
