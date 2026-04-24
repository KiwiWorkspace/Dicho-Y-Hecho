# PowerShell script to translate Spanish to English in Java files
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

# Define translation mappings
$translations = @{
    # Entity field names
    "private String nombre;" = "private String firstName;"
    "private String apellido;" = "private String lastName;"
    "private Integer edad;" = "private Integer age;"
    "private String correo;" = "private String email;"
    "private String direccion;" = "private String address;"
    "private String contrasena;" = "private String password;"
    "private String identificador;" = "private String identifier;"
    
    # Usuario entity fields
    "private String nombreUsuario;" = "private String firstName;"
    "private String apellidoUsuario;" = "private String lastName;"
    "private String handleUsuario;" = "private String userHandle;"
    "private String emailUsuario;" = "private String email;"
    "private Integer edadUsuario;" = "private Integer age;"
    "private UsuarioRoles rolUsuario;" = "private UsuarioRoles userRole;"
    
    # AreasVerdes entity fields
    "private String nombreArea;" = "private String areaName;"
    "private String tipoArea;" = "private String areaType;"
    "private String ubicacionArea;" = "private String areaLocation;"
    "private String estadoArea;" = "private String areaStatus;"
    
    # Locales entity fields
    "private Integer id_locales;" = "private Integer id;"
    "private String id_categoria;" = "private String categoryId;"
    "private String direccion_asociada;" = "private String associatedAddress;"
    "private String motivoRechazo;" = "private String rejectionReason;"
    
    # Problemas entity fields
    "private Integer id_problema;" = "private Integer id;"
    "private CategoriaProblema categoria;" = "private CategoriaProblema category;"
    "private EstadoProblema estado;" = "private EstadoProblema status;"
    
    # Comentarios entity fields
    "private long idComentario;" = "private long id;"
    "private LocalDateTime fechaComentario;" = "private LocalDateTime commentDate;"
    
    # Error messages - validation
    "Debe ingresar un nombre " = "You must enter a name "
    "Debe ingresar un apellido " = "You must enter a last name "
    "Debe ingresar un apodo para su  usuario" = "You must enter a username"
    "Debe ingresar una contrasena" = "You must enter a password"
    "Debe ingresar una edad " = "You must enter an age "
    "Por favor ingrese el nombre de su negocio" = "Please enter your business name"
    "Por favor ingrese la descripción de su negocio" = "Please enter your business description"
    "Por favor ingrese el número de teléfono de su negocio" = "Please enter your business phone number"
    "Por favor ingrese el correo de su negocio" = "Please enter your business email"
    "Debe ingresar el tipo del problema" = "You must enter the problem type"
    "Debe ingresar la dirección donde se ubica el problema" = "You must enter the location of the problem"
    "Debe ingresar la categoria del problema" = "You must enter the problem category"
    "Debe ingresar la estado en el que se encuentre el problema" = "You must enter the problem status"
    "Debe ingresar el estado de la notificación" = "You must enter the notification status"
    "Debe ingresar el nombre del area" = "You must enter the area name"
    "Debe ingresar el tipo del area" = "You must enter the area type"
    "Debe ingresar la ubicacion del area" = "You must enter the area location"
    "Debe ingresar el estado del area" = "You must enter the area status"
    "Debe ingresar contenido para su comentario" = "You must enter content for your comment"
    
    # Character range messages
    "Su nombre  debe tener 2 y 60 caracteres" = "Your name must have between 2 and 60 characters"
    "Su apellido  debe tener 2 y 60 caracteres" = "Your last name must have between 2 and 60 characters"
    "Su apodo debe tener 3 y 60 caracteres" = "Your username must have between 3 and 60 characters"
    "La contraseña debe terner de 8 a 12 caracteres" = "The password must have between 8 and 12 characters"
    "La edad debe ser mayor a 3" = "The age must be greater than 3"
    "La edad debe ser menor a 135" = "The age must be less than 135"
    "El nombre del negocio tiene como máximo 100 caracteres" = "The business name has a maximum of 100 characters"
    "La descripción debe tener mínimo 50 caracteres y máximo 300" = "The description must have a minimum of 50 characters and maximum 300"
    "El número de teléfono no puede exceder 12 caracteres" = "The phone number cannot exceed 12 characters"
    "El correo ingresado no tiene un formato válido" = "The email entered does not have a valid format"
    "El correo no puede exceder 50 caracteres" = "The email cannot exceed 50 characters"
    "El tipo de problema debe tener 20 y 130 caracteres" = "The problem type must have between 20 and 130 characters"
    "La direccion del problema debe tener 20 y 120 caracteres" = "The problem address must have between 20 and 120 characters"
    "El nombre del area debe tener entre 3 y 60 caracteres" = "The area name must have between 3 and 60 characters"
    "El tipo de area debe tener entre 3 y 30 caracteres" = "The area type must have between 3 and 30 characters"
    "La ubicacion del area debe tener entre 3 y 50 caracteres" = "The area location must have between 3 and 50 characters"
    "El estado del area debe tener entre 3 y 30 caracteres" = "The area status must have between 3 and 30 characters"
    
    # Service error messages
    "El email ya está registrado" = "The email is already registered"
    "Email Incorrecto o no existe" = "Incorrect email or does not exist"
    "Contraseña incorrecta" = "Incorrect password"
    "Login correcto: " = "Successful login: "
    "Usuario no encontrado" = "User not found"
    "Usuario con Id no encontrado :" = "User with Id not found:"
    "Usuario con ID no encontrado: " = "User with ID not found: "
    "El comentario no existe" = "The comment does not exist"
    "No tienes permiso para eliminar este comentario" = "You do not have permission to delete this comment"
    "Problema con ID no encontrado " = "Problem with ID not found "
    "Local con ID no encontrado: " = "Local with ID not found: "
    "El local con ID " = "The local with ID "
    "no está en estado PENDIENTE, está: " = "is not in PENDING status, it is: "
    "Debe proporcionar un motivo de rechazo" = "You must provide a reason for rejection"
    "Administrador con ID no encontrado: " = "Administrator with ID not found: "
    "Area verde con ID no encontrada: " = "Green area with ID not found: "
    
    # Controller messages
    "Usuario registrado correctamente" = "User registered successfully"
    "Comentario publicado" = "Comment published"
    "Error al publicar: " = "Error publishing: "
    "Comentario eliminado" = "Comment deleted"
    "El valor debe ser mayor a 1" = "The value must be greater than 1"
    "el id debe ser mayor a 0" = "The id must be greater than 0"
    
    # Email messages
    "Registro verificado" = "Registration verified"
    "Su registro se a realizado exitosamente" = "Your registration has been completed successfully"
    
    # Exception messages
    "La estructura del JSON es incorrecta" = "The JSON structure is incorrect"
    "Debe indicar una decisión: APROBADO o RECHAZADO" = "You must indicate a decision: APPROVED or REJECTED"
    "El ID de usuario es obligatorio" = "The user ID is mandatory"
    "se va a utiliza para que se coloque automaticamente la fecha" = "Used to automatically set the date"
    "El admin solo puede enviar APROBADO o RECHAZADO, nunca PENDIENTE" = "The admin can only send APPROVED or REJECTED, never PENDING"
    "Obligatorio solo si la decisión es RECHAZADO, se valida en el servicio" = "Mandatory only if the decision is REJECTED, validated in service"
    "recibir imagen y video de post" = "Receive image and video from post"
}

# Get all Java files
$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse

Write-Host "Found $($javaFiles.Count) Java files to process"

foreach ($file in $javaFiles) {
    $content = Get-Content -Path $file.FullName -Raw
    $modified = $false
    
    foreach ($spanish in $translations.Keys) {
        if ($content -contains $spanish) {
            $content = $content -replace [regex]::Escape($spanish), $translations[$spanish]
            $modified = $true
        }
    }
    
    if ($modified) {
        Set-Content -Path $file.FullName -Value $content -NoNewline
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "Translation complete!"
