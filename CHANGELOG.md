# Historial de cambios

Las entradas siguientes describen las etapas del ejercicio, no etiquetas Git ni releases publicadas. El repositorio ya está publicado en GitHub y la documentación HTML se publica mediante GitHub Pages. Las secciones antiguas conservan el estado que tenía el proyecto en aquel momento.

## 08/10/2026 - README y herramientas de documentación

- Se incorporó al proyecto la carpeta `.opencode` proporcionada por la profesora, con las skills de documentación y licencia. Copiarla no implica ejecutar sus recomendaciones ni asignar una licencia al código.
- Se reorganizó el README siguiendo la skill de documentación: descripción, características, arquitectura y tecnologías, requisitos, puesta en marcha, pruebas, limitaciones y licencia/contacto.
- Se conservaron las capturas actuales y las evidencias de Logcat y del directorio de la aplicación.
- El README superó el validador de la skill sin advertencias y se comprobaron las rutas de sus imágenes.
- Se actualizó este historial para distinguir los pendientes históricos de los pasos completados posteriormente.
- Estos cambios de documentación no implican una nueva ejecución de las pruebas Android ni su publicación automática en GitHub.

### Firma de prueba

- Se compiló la versión release y se generó un APK firmado con un certificado autofirmado a nombre de Javier Agradano Krasimirova.
- Se verificó la firma del APK. Inicialmente se guardó fuera del repositorio y después se copió a la raíz del proyecto como `app-release.apk`, conforme a la tarea 8. No se instaló en el emulador ni se publicó en GitHub.
- La clave privada y los datos de firma permanecen fuera del repositorio y no se incluyen con el APK.

## 06/10/2026 - KDoc, Parcelize y capturas actuales

- Se ampliaron los comentarios KDoc de `Message` y `Person`, con formato Markdown y documentación de sus propiedades.
- Se añadieron `@author` y `@version` a las dos actividades y se revisó el formato `/** ... */` de los comentarios.
- Se activó el plugin Kotlin Parcelize 2.2.10. Los modelos siguen implementando `Serializable`; no se migró el paso de datos a `Parcelable`.
- La compilación debug, las pruebas unitarias y la generación de documentación HTML con Dokka finalizaron correctamente. Las dos pruebas unitarias registraron cero errores y fallos.
- Se añadieron al README las capturas del formulario con remitente y mensaje y de la pantalla que recibe ambos datos, tomadas en el emulador Pixel.
- Se publicaron en GitHub el README actualizado y las dos capturas. Esa subida no incluyó los cambios de código, configuración de Parcelize ni HTML regenerado.

## 03/10/2026 - Publicación de Dokka en GitHub Pages

- Se ajustó el workflow `.github/workflows/desplegar-dokka.yml` para generar la documentación con `:app:dokkaGeneratePublicationHtml`, comprobar `docs/index.html` y publicar la carpeta `docs`.
- Se completó una ejecución del workflow y se comprobó el acceso a la documentación publicada en GitHub Pages.
- El repositorio quedó disponible en GitHub. Este paso no equivale a publicar una release ni a distribuir la aplicación en una tienda.

## 01/10/2026 - Generación local de documentación HTML

- Se configuró Dokka para generar el HTML en la carpeta `docs` de la raíz del proyecto.
- Se ejecutó correctamente la tarea `:app:dokkaGeneratePublicationHtml` y se abrió `docs/index.html` en el navegador.
- Se comprobó que la documentación incluía las actividades y las clases `Message` y `Person`.

## 30/09/2026 - Remitente y objeto serializable

- Se añadió un campo para escribir el remitente.
- Se crearon los modelos `Person` y `Message`, ambos serializables.
- El Intent transporta el objeto `Message` con el texto y su `Person` remitente.
- La segunda pantalla recupera el objeto y muestra ambos datos.
- Se ampliaron las pruebas del flujo para comprobar el remitente.

## v1.0 - Paso de datos completado y documentación generada

### Realizado

- Lectura del mensaje al pulsar el botón de la primera pantalla.
- Apertura de ViewActivity mediante un Intent explícito, con el mensaje como extra.
- Recepción y presentación del texto en la segunda pantalla.
- Estilo de texto compartido entre ambas pantallas.
- Registro del ciclo de vida con TAG propios y agrupación de métodos en una región.
- Verificación del flujo en el emulador, de los breakpoints y de tres pruebas de instrumentación.
- Comentarios KDoc, README, manual de usuario y evidencias visuales de ejecución, Logcat y acceso al directorio de la aplicación.
- Documentación HTML generada con Dokka en `docs`, completada el 01/10/2026 y publicada posteriormente en GitHub Pages.

### Evolución de los pendientes iniciales

- Generar la documentación HTML con Dokka en `docs` (tarea 6): completado el 01/10/2026.
- Publicar el proyecto y la documentación: repositorio publicado y despliegue de GitHub Pages comprobado el 03/10/2026; los cambios locales posteriores requieren su propia subida.
- Revisar el ajuste del padding: sigue pendiente.

La generación de HTML y la publicación se completaron posteriormente, como se recoge en las entradas fechadas de este historial.

## v0.1 - Configuración inicial y pantallas

- Creación del proyecto SendMessage y configuración del emulador.
- Ajuste de la versión de compilación para las dependencias AndroidX.
- Icono de lanzamiento e icono vectorial de chat.
- Creación de MainActivity y ViewActivity.
- Diseños XML con LinearLayout vertical: entrada y botón en la primera pantalla; texto e imagen en la segunda.
- Identificadores de los componentes y recursos de cadenas, colores y dimensiones.

## Pendientes actuales conocidos

- Revisar el listener de las barras del sistema, que sustituye el padding definido en XML.
- Ejecutar en un dispositivo o emulador las pruebas de interfaz del flujo actualizado con remitente; su compilación no acredita su ejecución.
- Decidir una licencia explícita si se desea añadir un archivo `LICENSE`; no se ha seleccionado una automáticamente.
- Los cambios locales requieren una subida autorizada para reflejarse en GitHub. Este historial no certifica que todos los archivos del equipo estén publicados.
