# Historial de cambios

Las versiones siguientes describen las etapas del ejercicio. No son etiquetas Git ni publicaciones: todavía no se ha publicado el repositorio.

## 30/09/2026 - Remitente y objeto serializable

- Se añadió un campo para escribir el remitente.
- Se crearon los modelos `Person` y `Message`, ambos serializables.
- El Intent transporta el objeto `Message` con el texto y su `Person` remitente.
- La segunda pantalla recupera el objeto y muestra ambos datos.
- Se ampliaron las pruebas del flujo para comprobar el remitente.

## v1.0 - Paso de datos completado; documentación en preparación

### Realizado

- Lectura del mensaje al pulsar el botón de la primera pantalla.
- Apertura de ViewActivity mediante un Intent explícito, con el mensaje como extra.
- Recepción y presentación del texto en la segunda pantalla.
- Estilo de texto compartido entre ambas pantallas.
- Registro del ciclo de vida con TAG propios y agrupación de métodos en una región.
- Verificación del flujo en el emulador, de los breakpoints y de tres pruebas de instrumentación.
- Comentarios KDoc, README, manual de usuario y evidencias visuales de ejecución, Logcat y acceso al directorio de la aplicación.

### Pendiente para cerrar la versión solicitada en el enunciado

- Generar la documentación HTML con Dokka en `/docs` (tarea 6). La documentación no está generada todavía; esta entrada no certifica ese paso.
- Publicar los archivos y evidencias en GitHub cuando se realice la tarea de publicación.
- Revisar el ajuste del padding que se dejó pendiente durante la tutoría.

## v0.1 - Configuración inicial y pantallas

- Creación del proyecto SendMessage y configuración del emulador.
- Ajuste de la versión de compilación para las dependencias AndroidX.
- Icono de lanzamiento e icono vectorial de chat.
- Creación de MainActivity y ViewActivity.
- Diseños XML con LinearLayout vertical: entrada y botón en la primera pantalla; texto e imagen en la segunda.
- Identificadores de los componentes y recursos de cadenas, colores y dimensiones.

## Nota sobre la implementación asistida

El 28 de septiembre de 2026, el alumno pidió completar temporalmente la lógica restante de la tarea 4 y preparar la tarea 7 con IA. Si se retira esa lógica para continuar aprendiendo paso a paso, será necesario actualizar la documentación y sus evidencias antes de la entrega definitiva.
