# scanner-mixed-input-single-scanner
Java Scanner with mixed numeric and text input
## Features
* Use of a scanner without the "quirk" needed to mix numeric and text input.
* Use of a scanner with the "quirk" needed to mix numeric and text input.
## Change History
* 2023-09-26 - upgraded to Java 21 Long Term Support (LTS) version
## Example run
``1
java.runtime.version=21+35-LTS-2513

SingleScannerWithQuirkWorkaround
What is your first name?> Fred
How old are you?> 10
What is your last name?> Morrison
What is your weekly wage rate?> 123
Morrison, Fred, age 10, wages $123.00

SingleScannerWithoutQuirkWorkaround
What is your first name?> fred
How old are you?> 10
What is your last name?> morrison
What is your weekly wage rate?> 789.9
morrison, fred, age 10, wages $789.90
Done
```
