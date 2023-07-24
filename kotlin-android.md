# Android Kotlin

# Surface in Jetpack Comapose

## References

- https://hey-agrawal.medium.com/surface-in-jetpack-compose-c0712d38b994
- https://www.composables.com/components/material/surface

## Parameters in Surface

> modifier: Modifier to apply to the surface
color: Background color of the surface
elevation: Elevation of the surface, which adds a shadow effect
shape: Shapes of the surface, such as a rounded rectangle or a cut-corner rectangle
border: Border around the surface
contentColor: Foreground color of the surface’s content
onClick: Click listener for the surface
enabled: Whether the surface is enabled or disabled
interactionSource: Interaction source for the surface
indication: Indication to show when the surface interacted with
semantics: Accessibility properties for the surface
content: The content of the surface, specified as a composable function.


# @Composable

Composable functions are a fundamental concept in Jetpack Compose, which is a modern 
UI toolkit introduced by Google for building native Android user interfaces.

When using the @Composable annotation, the function can take input parameters and return 
UI elements, and it is intended to be a pure function without side effects.

```kotlin
@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
    )
}
```