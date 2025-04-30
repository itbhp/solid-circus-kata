# Circus Kata 2: AcrobatShowPass

![Entrada para el circo](circus-ticket2.png)

- **Single Responsibility Principle**: un módulo debería tener una única razón para cambiar.
- **Dependency Inversion Principle**: el código de alto nivel debe depender de abstracciones, no de implementaciones concretas.

En esta kata vamos a partir de una clase:

### class `AcrobatShowPass`

- Incumple el principio **Single Responsibility Principle (SRP)** porque tiene diferentes razones para cambiar (identifica cuáles son 🔍)
- Ahora mismo no, pero cuando extraigas responsabilidades a sus propias clases, esta clase `AcrobatShowPass` podrá incumplir el **Dependency Inversion Principle (DIP)**.

## Objetivo

El objetivo de esta kata es refactorizar la clase `AcrobatShowPass` aplicando los principios de diseño **SOLID**, en particular el **Single Responsibility Principle (SRP)** y el **Dependency Inversion Principle (DIP)**.

## Tests

Los tests están cubriendo las funcionalidades de imprimir y de guardar. En esta kata el guardado se está simulando mediante un `System.out.println`.

## Scripts

Recuerda instalar las dependencias desde esta carpeta con:

`mvn install`

Para lanzar los tests:

`mvn test`
