# Enhanced PowerShell script for bulk translation
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

# Get all Java files recursively
$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse

Write-Host "Processing $($javaFiles.Count) Java files..."
$updateCount = 0

foreach ($file in $javaFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $originalContent = $content
    
    # Method names and field name replacements
    $content = $content -replace "getNombre\(\)", "getFirstName()"
    $content = $content -replace "setNombre\(", "setFirstName("
    $content = $content -replace "getApellido\(\)", "getLastName()"
    $content = $content -replace "setApellido\(", "setLastName("
    $content = $content -replace "getEdad\(\)", "getAge()"
    $content = $content -replace "setEdad\(", "setAge("
    $content = $content -replace "getCorreo\(\)", "getEmail()"
    $content = $content -replace "setCorreo\(", "setEmail("
    $content = $content -replace "getDireccion\(\)", "getAddress()"
    $content = $content -replace "setDireccion\(", "setAddress("
    $content = $content -replace "getContrasena\(\)", "getPassword()"
    $content = $content -replace "setContrasena\(", "setPassword("
    $content = $content -replace "getIdentificador\(\)", "getIdentifier()"
    $content = $content -replace "setIdentificador\(", "setIdentifier("
    
    # Additional field name replacements for Usuario
    $content = $content -replace "getNombreUsuario\(\)", "getFirstName()"
    $content = $content -replace "setNombreUsuario\(", "setFirstName("
    $content = $content -replace "getApellidoUsuario\(\)", "getLastName()"
    $content = $content -replace "setApellidoUsuario\(", "setLastName("
    $content = $content -replace "getHandleUsuario\(\)", "getUserHandle()"
    $content = $content -replace "setHandleUsuario\(", "setUserHandle("
    $content = $content -replace "getEmailUsuario\(\)", "getEmail()"
    $content = $content -replace "setEmailUsuario\(", "setEmail("
    $content = $content -replace "getEdadUsuario\(\)", "getAge()"
    $content = $content -replace "setEdadUsuario\(", "setAge("
    $content = $content -replace "getRolUsuario\(\)", "getUserRole()"
    $content = $content -replace "setRolUsuario\(", "setUserRole("
    $content = $content -replace "getIdUsuario\(\)", "getId()"
    $content = $content -replace "setIdUsuario\(", "setId("
    
    # Replace validation messages  
    $content = $content -replace 'Debe ingresar un nombre del administrador', 'You must enter an administrator first name'
    $content = $content -replace 'El nombre del administrador debe tener 4 y 60 caracteres', 'The administrator first name must have between 4 and 60 characters'
    $content = $content -replace 'Debe ingresar un apellido del administrador', 'You must enter an administrator last name'
    $content = $content -replace 'El apellido del administrador debe tener 2 y 60 caracteres', 'The administrator last name must have between 2 and 60 characters'
    $content = $content -replace 'La edad no puede ir vacia\.', 'The age cannot be empty.'
    $content = $content -replace 'La edad debe ser mayor o igual a 1\.', 'The age must be greater than or equal to 1.'
    $content = $content -replace 'La edad debe ser menor o igual a 120\.', 'The age must be less than or equal to 120.'
    $content = $content -replace 'Debe ingresar la direccion de residencia del administrador', 'You must enter the residential address of the administrator'
    $content = $content -replace 'La direccion de residencia del administrador debe tener 20 y 120 caracteres', 'The residential address of the administrator must have between 20 and 120 characters'
    $content = $content -replace 'Debe registrar un correo Electronico para poder registrarse', 'You must register an email address to be able to register'
    $content = $content -replace 'El correo electrico debe contar con un min de 12 caracteres y maximo de 72\.', 'The email must have a minimum of 12 characters and maximum of 72.'
    $content = $content -replace 'Debe ingresar la contraseña del administrador', 'You must enter the administrator password'
    $content = $content -replace 'La contraseña debe tener un min de 8 y max 13 caracteres', 'The password must have a minimum of 8 and maximum of 13 characters'
    
    # Usuario validation messages
    $content = $content -replace 'Debe ingresar un nombre ', 'You must enter a name '
    $content = $content -replace 'Su nombre  debe tener 2 y 60 caracteres', 'Your name must have between 2 and 60 characters'
    $content = $content -replace 'Debe ingresar un apellido ', 'You must enter a last name '
    $content = $content -replace 'Su apellido  debe tener 2 y 60 caracteres', 'Your last name must have between 2 and 60 characters'
    $content = $content -replace 'Debe ingresar un apodo para su  usuario', 'You must enter a username'
    $content = $content -replace 'Su apodo debe tener 3 y 60 caracteres', 'Your username must have between 3 and 60 characters'
    $content = $content -replace 'Debe ingresar una contrasena', 'You must enter a password'
    $content = $content -replace 'La contraseña debe terner de 8 a 12 caracteres', 'The password must have between 8 and 12 characters'
    $content = $content -replace 'Debe ingresar una edad ', 'You must enter an age '
    $content = $content -replace 'La edad debe ser mayor a 3', 'The age must be greater than 3'
    $content = $content -replace 'La edad debe ser menor a 135', 'The age must be less than 135'
    
    # Locales validation messages
    $content = $content -replace 'Por favor ingrese el nombre de su negocio\.', 'Please enter your business name.'
    $content = $content -replace 'El nombre del negocio tiene como máximo 100 caracteres\.', 'The business name has a maximum of 100 characters.'
    $content = $content -replace 'Por favor ingrese la descripción de su negocio\.', 'Please enter your business description.'
    $content = $content -replace 'La descripción debe tener mínimo 50 caracteres y máximo 300\.', 'The description must have a minimum of 50 characters and maximum 300.'
    $content = $content -replace 'Por favor ingrese el número de teléfono de su negocio\.', 'Please enter your business phone number.'
    $content = $content -replace 'El número de teléfono no puede exceder 12 caracteres\.', 'The phone number cannot exceed 12 characters.'
    $content = $content -replace 'Por favor ingrese el correo de su negocio\.', 'Please enter your business email.'
    $content = $content -replace 'El correo ingresado no tiene un formato válido\.', 'The email entered does not have a valid format.'
    $content = $content -replace 'El correo no puede exceder 50 caracteres\.', 'The email cannot exceed 50 characters.'
    
    # Problemas validation messages
    $content = $content -replace 'Debe ingresar el tipo del problema', 'You must enter the problem type'
    $content = $content -replace 'El tipo de problema debe tener 20 y 130 caracteres', 'The problem type must have between 20 and 130 characters'
    $content = $content -replace 'Debe ingresar la dirección donde se ubica el problema', 'You must enter the location of the problem'
    $content = $content -replace 'Debe ingresar la direccion de donde se ubica el problema', 'You must enter the location of the problem'
    $content = $content -replace 'La direccion del problema debe tener 20 y 120 caracteres', 'The problem address must have between 20 and 120 characters'
    $content = $content -replace 'Debe ingresar la categoria del problema', 'You must enter the problem category'
    $content = $content -replace 'Debe ingresar la estado en el que se encuentre el problema', 'You must enter the problem status'
    $content = $content -replace 'Debe ingresar el estado de la notificación', 'You must enter the notification status'
    
    # AreasVerdes validation messages
    $content = $content -replace 'Debe ingresar el nombre del area', 'You must enter the area name'
    $content = $content -replace 'El nombre del area debe tener entre 3 y 60 caracteres', 'The area name must have between 3 and 60 characters'
    $content = $content -replace 'Debe ingresar el tipo del area', 'You must enter the area type'
    $content = $content -replace 'El tipo de area debe tener entre 3 y 30 caracteres', 'The area type must have between 3 and 30 characters'
    $content = $content -replace 'Debe ingresar la ubicacion del area', 'You must enter the area location'
    $content = $content -replace 'La ubicacion del area debe tener entre 3 y 50 caracteres', 'The area location must have between 3 and 50 characters'
    $content = $content -replace 'Debe ingresar el estado del area', 'You must enter the area status'
    $content = $content -replace 'El estado del area debe tener entre 3 y 30 caracteres', 'The area status must have between 3 and 30 characters'
    
    # Comentarios validation
    $content = $content -replace 'Debe ingresar contenido para su comentario ', 'You must enter content for your comment '
    
    # Service error messages
    $content = $content -replace 'El email ya está registrado\.', 'The email is already registered.'
    $content = $content -replace 'Email Incorrecto o no existe\.', 'Incorrect email or does not exist.'
    $content = $content -replace 'Contraseña incorrecta', 'Incorrect password'
    $content = $content -replace 'Login correcto: ', 'Successful login: '
    $content = $content -replace 'Usuario no encontrado', 'User not found'
    $content = $content -replace 'Usuario con Id no encontrado :', 'User with Id not found:'
    $content = $content -replace 'Usuario con ID no encontrado: ', 'User with ID not found: '
    $content = $content -replace 'El comentario no existe\.', 'The comment does not exist.'
    $content = $content -replace 'No tienes permiso para eliminar este comentario\.', 'You do not have permission to delete this comment.'
    $content = $content -replace 'Problema con ID no encontrado ', 'Problem with ID not found '
    $content = $content -replace 'Local con ID no encontrado: ', 'Local with ID not found: '
    $content = $content -replace 'no está en estado PENDIENTE, está: ', 'is not in PENDING status, it is: '
    $content = $content -replace 'Debe proporcionar un motivo de rechazo\.', 'You must provide a reason for rejection.'
    $content = $content -replace 'Administrador con ID no encontrado: ', 'Administrator with ID not found: '
    $content = $content -replace 'Administrador con ID no encontrado ', 'Administrator with ID not found '
    $content = $content -replace 'Area verde con ID no encontrada: ', 'Green area with ID not found: '
    
    # Controller messages
    $content = $content -replace 'Usuario registrado correctamente\.', 'User registered successfully.'
    $content = $content -replace 'Comentario publicado', 'Comment published'
    $content = $content -replace 'Error al publicar: ', 'Error publishing: '
    $content = $content -replace 'Comentario eliminado\.\.', 'Comment deleted.'
    $content = $content -replace 'El valor debe ser mayor a 1', 'The value must be greater than 1'
    $content = $content -replace 'el id debe ser mayor a 0', 'The id must be greater than 0'
    
    # Email service messages
    $content = $content -replace 'Registro verificado', 'Registration verified'
    $content = $content -replace 'Su registro se a realizado exitosamente', 'Your registration has been completed successfully'
    
    # Exception messages
    $content = $content -replace 'La estructura del JSON es incorrecta\.', 'The JSON structure is incorrect.'
    $content = $content -replace 'Debe indicar una decisión: APROBADO o RECHAZADO\.', 'You must indicate a decision: APPROVED or REJECTED.'
    $content = $content -replace 'El ID de usuario es obligatorio', 'The user ID is mandatory'
    
    # Comments
    $content = $content -replace 'se va a utiliza para que se coloque automaticamente la fecha', 'Used to automatically set the date'
    $content = $content -replace 'El admin solo puede enviar APROBADO o RECHAZADO, nunca PENDIENTE', 'The admin can only send APPROVED or REJECTED, never PENDING'
    $content = $content -replace 'Obligatorio solo si la decisión es RECHAZADO, se valida en el servicio', 'Mandatory only if the decision is REJECTED, validated in service'
    $content = $content -replace 'recibir imagen y video de post', 'Receive image and video from post'
    $content = $content -replace 'constructores', 'constructors'
    
    # Replace PENDIENTE/APROBADO/RECHAZADO enum references with new values
    $content = $content -replace 'EstadoLocales\.PENDIENTE', 'EstadoLocales.PENDING'
    $content = $content -replace 'EstadoLocales\.APROBADO', 'EstadoLocales.APPROVED'
    $content = $content -replace 'EstadoLocales\.RECHAZADO', 'EstadoLocales.REJECTED'
    
    # Replace old problema enum values
    $content = $content -replace 'CategoriaProblema\.NIVEL_BAJO', 'CategoriaProblema.LOW'
    $content = $content -replace 'CategoriaProblema\.NIVEL_MODERADO', 'CategoriaProblema.MODERATE'
    $content = $content -replace 'CategoriaProblema\.NIVEL_ALTO', 'CategoriaProblema.HIGH'
    $content = $content -replace 'CategoriaProblema\.NIVEL_CRITICO', 'CategoriaProblema.CRITICAL'
    
    # Replace Estado Problema enums
    $content = $content -replace 'EstadoProblema\.REPORTADO', 'EstadoProblema.REPORTED'
    $content = $content -replace 'EstadoProblema\.EN_INSPECCION_TECNICA', 'EstadoProblema.TECHNICAL_INSPECTION'
    $content = $content -replace 'EstadoProblema\.PENDIENTE_DE_APROBACION', 'EstadoProblema.PENDING_APPROVAL'
    $content = $content -replace 'EstadoProblema\.EN_REVISION', 'EstadoProblema.UNDER_REVIEW'
    $content = $content -replace 'EstadoProblema\.PROGRAMADO', 'EstadoProblema.SCHEDULED'
    $content = $content -replace 'EstadoProblema\.EN_PROCESO', 'EstadoProblema.IN_PROGRESS'
    $content = $content -replace 'EstadoProblema\.RESUELTO', 'EstadoProblema.RESOLVED'
    $content = $content -replace 'EstadoProblema\.RECHAZADO', 'EstadoProblema.REJECTED'
    
    # Replace UsuarioRoles enums
    $content = $content -replace 'UsuarioRoles\.POLICIA_NACIONAL_CIVIL', 'UsuarioRoles.NATIONAL_POLICE'
    $content = $content -replace 'UsuarioRoles\.POLICIA_MUNICIPAL', 'UsuarioRoles.MUNICIPAL_POLICE'
    $content = $content -replace 'UsuarioRoles\.POLICIA_MUNICIPAL_DE_TRANSITO', 'UsuarioRoles.TRAFFIC_POLICE'
    $content = $content -replace 'UsuarioRoles\.BOMBERO_MUNICIPAL', 'UsuarioRoles.MUNICIPAL_FIREFIGHTER'
    $content = $content -replace 'UsuarioRoles\.BOMBERO_VOLUNTARIO', 'UsuarioRoles.VOLUNTEER_FIREFIGHTER'
    $content = $content -replace 'UsuarioRoles\.AGENTE_CONRED', 'UsuarioRoles.CONRED_AGENT'
    $content = $content -replace 'UsuarioRoles\.EJERCITO_DE_GUATEMALA', 'UsuarioRoles.GUATEMALA_ARMY'
    $content = $content -replace 'UsuarioRoles\.PERSONAL_DE_SALUD_PUBLICA', 'UsuarioRoles.PUBLIC_HEALTH_PERSONNEL'
    $content = $content -replace 'UsuarioRoles\.GESTOR_DE_TRANSMETRO', 'UsuarioRoles.TRANSMETRO_MANAGER'
    $content = $content -replace 'UsuarioRoles\.PERSONAL_DE_ORNATO', 'UsuarioRoles.ORNAMENT_PERSONNEL'
    $content = $content -replace 'UsuarioRoles\.PERSONALIDAD_DE_MUNICIPALIDAD', 'UsuarioRoles.MUNICIPAL_OFFICIAL'
    $content = $content -replace 'UsuarioRoles\.JUEZ_DE_ASUNTOS_MUNICIPALES', 'UsuarioRoles.MUNICIPAL_JUDGE'
    $content = $content -replace 'UsuarioRoles\.VECINO', 'UsuarioRoles.RESIDENT'
    
    if ($content -ne $originalContent) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
        $updateCount++
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "`nTranslation complete! Updated $updateCount files."
