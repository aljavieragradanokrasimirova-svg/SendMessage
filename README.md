# SendMessage

Ejercicio de la Unidad 2: una aplicación Android con dos pantallas. El usuario escribe un remitente y un mensaje en la primera, y ve ambos en la segunda junto a un icono vectorial.

El nombre «enviar» se refiere al paso de datos entre pantallas de esta aplicación. No se envían SMS ni mensajes por Internet y no se mantiene un historial.

## Aplicación en ejecución

Capturas reales del emulador Pixel, tomadas el 6 de octubre de 2026. Muestran el envío de un mensaje junto con su remitente y la recepción de ambos en la segunda pantalla.

### Escribir el mensaje

<img src="Screenshots/Screenshot_20261006_094927.png" alt="Formulario con el remitente Paco, el mensaje Pocholo y el botón Enviar mensaje" width="300">

### Ver el mensaje recibido

<img src="Screenshots/Screenshot_20261006_094938.png" alt="Segunda pantalla con De: Paco, el mensaje Pocholo y el icono vectorial de chat" width="300">

## Estructura del proyecto

| Archivo o carpeta | Función |
| --- | --- |
| `app/src/main/java/com/example/sendmessage/MainActivity.kt` | Recoge remitente y texto y envía el objeto Message mediante un Intent explícito. |
| `app/src/main/java/com/example/sendmessage/ViewActivity.kt` | Recupera el objeto y muestra remitente y texto. |
| `app/src/main/java/com/example/sendmessage/model/` | Clases serializables Person y Message. |
| `app/src/main/res/layout/activity_main.xml` | Campos para remitente y mensaje, más el botón de envío. |
| `app/src/main/res/layout/activity_view.xml` | Remitente, texto recibido e imagen. |
| `app/src/main/res/values/` | Cadenas, colores, dimensiones, estilos y temas. |
| `app/src/main/res/drawable/` | Recursos gráficos; incluye el vector de chat usado dentro de la app. |
| `app/src/main/res/mipmap-*/` | Iconos de lanzamiento para distintas densidades. |
| `app/src/main/AndroidManifest.xml` | Declara las actividades y la pantalla de inicio. |
| `app/src/androidTest/` | Pruebas ejecutadas en el emulador. |
| `gradle/libs.versions.toml` | Catálogo de versiones y dependencias. |
| `Screenshots/` | Capturas actuales del formulario y del mensaje recibido. |
| `documentacion/imagenes/` | Evidencias de Logcat y del directorio de la aplicación. |

## Decisiones de diseño

- La interfaz está declarada en XML y la lógica está escrita en Kotlin, para mantenerlas separadas.
- Las dos pantallas utilizan un `LinearLayout` vertical. Sus elementos aparecen uno debajo de otro, en el orden del XML.
- Se conserva el nombre `MainActivity` creado en el proyecto; cumple el papel de la pantalla de envío denominada SendActivity en el enunciado. La segunda se llama `ViewActivity`.
- `findViewById` localiza los campos `senderName` y `userMessage` y el botón `sendMsgButton`.
- Los textos se leen dentro del `setOnClickListener`, cuando el usuario pulsa el botón. Se crea un `Message` que contiene el texto y una `Person` remitente. Ambas clases implementan `Serializable`.
- Un Intent explícito indica la actividad de destino; `putExtra` adjunta el objeto y `startActivity` abre la pantalla. La clave compartida `MainActivity.EXTRA_MESSAGE` permite recuperarlo con `getSerializableExtra`. Si falta, ambos textos quedan vacíos.
- Cadenas, colores y dimensiones se guardan en recursos. El estilo `MessageText` comparte la fuente `sans`, el tamaño de 18sp y el color `#6750A4` entre el campo/etiqueta de origen y el texto de destino.
- El icono de chat de la segunda pantalla es decorativo y está excluido de la lectura de accesibilidad. No es el icono de lanzamiento.
- Los comentarios KDoc explican las actividades, la clave del extra y los métodos del ciclo de vida.
- Se mantiene pendiente el ajuste del padding: el listener de las barras del sistema todavía sustituye el padding definido en el XML. No se ha cambiado esta parte durante la documentación.

## Ejecución y comprobaciones

Abrir el proyecto en Android Studio, dejar que Gradle sincronice, seleccionar un emulador y ejecutar la configuración `app` con Run. La versión mínima configurada es Android API 24.

Configuración comprobada: `compileSdk` 37.1, `targetSdk` 36 y Android Gradle Plugin 9.2.1. La compilación funciona, aunque este plugin advierte que se ha probado hasta API 37.0. No se ha ocultado esa advertencia.

Comandos de verificación utilizados desde la raíz del proyecto en Windows:

```powershell
./gradlew.bat assembleDebug
./gradlew.bat connectedDebugAndroidTest
```

Tras el cambio del 30/09/2026, `assembleDebug`, `assembleDebugAndroidTest` y `testDebugUnitTest` terminaron correctamente. La prueba unitaria confirma que un `Message` serializado conserva también su `Person` remitente. Las pruebas de instrumentación se compilaron, pero no se ejecutaron tras este cambio porque no había ningún emulador conectado; conviene ejecutarlas antes de la entrega.

## Depuración y evidencia de Logcat

Las actividades llaman a `Log.d` con los TAG `SendMessage.Main` y `SendMessage.View`. Registran `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart` y `onDestroy`, agrupados en una región del IDE.

Se ejecutó en modo Debug y se comprobó la parada en breakpoints de `onCreate`, `onResume` y `onPause` de MainActivity y `onCreate` de ViewActivity. Después se detuvo Debug y se ejecutó normalmente para tomar las capturas. Los números de línea cambian al añadir comentarios; los breakpoints se deben revisar por el método, no por un número fijo.

Al abrir la segunda pantalla se observa la pausa de la primera y la creación, inicio y reanudación de la segunda. Al volver, se observan la reanudación de la primera y el cierre de la segunda. No debe darse por garantizada una llamada a `onDestroy` si Android termina el proceso.

Filtro de Logcat utilizado para aislar los mensajes de este ejercicio:

```text
package:com.example.sendmessage tag:SendMessage
```

![Evidencia real de los registros de SendMessage en Logcat](documentacion/imagenes/logcat.png)

## Conexión al directorio de la aplicación

La siguiente imagen muestra el acceso al directorio privado `/data/data/com.example.sendmessage` del emulador. Es una inspección del directorio, no una prueba de que los mensajes se guarden allí: esta aplicación los pasa mediante el Intent y no los guarda en un fichero.

![Conexión al directorio privado de SendMessage en el emulador](documentacion/imagenes/directorio-aplicacion.png)

## Documentación y versiones

- [Manual de usuario en tres pasos](MANUAL_USUARIO.md).
- [Historial de versiones](CHANGELOG.md).
- Documentación KDoc: incluida en los ficheros Kotlin.
- Documentación HTML generada con Dokka en `docs/`. La generación, la compilación y las pruebas unitarias se comprobaron de nuevo el 6/10/2026.
- [Documentación publicada en GitHub Pages](https://aljavieragradanokrasimirova-svg.github.io/SendMessage/).
- [Repositorio en GitHub](https://github.com/aljavieragradanokrasimirova-svg/SendMessage). El workflow `.github/workflows/desplegar-dokka.yml` genera y publica la documentación.

## Referencias oficiales

- [Intents y filtros de intents](https://developer.android.com/guide/components/intents-filters).
- [Ciclo de vida de una actividad](https://developer.android.com/guide/components/activities/activity-lifecycle).
- [Consultar registros con Logcat](https://developer.android.com/studio/debug/logcat).
- [Inspeccionar archivos con Device Explorer](https://developer.android.com/studio/debug/device-file-explorer).

La documentación de esta tarea se ha redactado con ayuda de IA, por indicación de la profesora. Describe el estado comprobado del proyecto; no sustituye el trabajo de comprensión del alumno.
