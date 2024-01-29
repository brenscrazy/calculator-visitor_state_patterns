# Парсер-калькурятор математических выражений
Данное приложение позволяет вычислять результат переданного математического выражения, содержащего рациональные числа, скобки и операции сложения, вычитания, умножения, деления. 
Реализованы приоритеты операций и анализ корректности переданного выражения. 

Для разбиения переданной строки на набор токенов используется класс [Tokenizer](https://github.com/brenscrazy/calculator-visitor_state_patterns/blob/master/src/main/java/tokens/Tokenizer.java), реализующий [state паттерн](https://en.wikipedia.org/wiki/State_pattern).

Полученный набор токенов переводится в обратную польскую нотацию с помощью класса [ParseVisitor](https://github.com/brenscrazy/calculator-visitor_state_patterns/blob/master/src/main/java/visitors/ParseVisitor.java),
после чего считается результат с помощью класса [CalcVisitor](https://github.com/brenscrazy/calculator-visitor_state_patterns/blob/master/src/main/java/visitors/CalcVisitor.java).
Последние два класса реализуют [visitor pattern](https://en.wikipedia.org/wiki/Visitor_pattern)
