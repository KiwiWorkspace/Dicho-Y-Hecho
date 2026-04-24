# Final comprehensive translation script - Phase 3
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse
Write-Host "Processing $($javaFiles.Count) Java files for final comprehensive translation..."
$updateCount = 0

foreach ($file in $javaFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $originalContent = $content
    
    # Rename classes
    $content = $content -replace 'class Administrador\b', 'class Administrator'
    $content = $content -replace 'class Locales\b', 'class Store'
    $content = $content -replace 'class Problemas\b', 'class Problem'
    $content = $content -replace 'class AreasVerdes\b', 'class GreenArea'
    $content = $content -replace 'class Comentarios\b', 'class Comment'
    $content = $content -replace 'class AutenController\b', 'class AuthController'
    $content = $content -replace 'class AutenService\b', 'class AuthService'
    $content = $content -replace 'class CorreoService\b', 'class EmailService'
    
    # Rename service class names
    $content = $content -replace 'AdministradorService\b', 'AdministratorService'
    $content = $content -replace 'AdministradorServiceImpl\b', 'AdministratorServiceImpl'
    $content = $content -replace 'LocalesService\b', 'StoreService'
    $content = $content -replace 'LocalesServiceImpl\b', 'StoreServiceImpl'
    $content = $content -replace 'ProblemasService\b', 'ProblemService'
    $content = $content -replace 'ProblemasServiceImpl\b', 'ProblemServiceImpl'
    $content = $content -replace 'AreasVerdesService\b', 'GreenAreaService'
    $content = $content -replace 'AreasVerdesServiceImpl\b', 'GreenAreaServiceImpl'
    $content = $content -replace 'AreasVerdesRepository\b', 'GreenAreaRepository'
    $content = $content -replace 'AreasVerdesController\b', 'GreenAreaController'
    
    # Rename repository classes
    $content = $content -replace 'AdministradorRepository\b', 'AdministratorRepository'
    $content = $content -replace 'LocalesRepository\b', 'StoreRepository'
    $content = $content -replace 'ProblemasRepository\b', 'ProblemRepository'
    $content = $content -replace 'ComentariosRepository\b', 'CommentRepository'
    
    # Rename controller classes
    $content = $content -replace 'AdministradorController\b', 'AdministratorController'
    $content = $content -replace 'LocalesController\b', 'StoreController'
    $content = $content -replace 'LocalesAdminController\b', 'AdminStoreController'
    $content = $content -replace 'ProblemasController\b', 'ProblemController'
    $content = $content -replace 'ComentarioController\b', 'CommentController'
    
    # Rename enum classes
    $content = $content -replace 'CategoriaProblema\b', 'ProblemCategory'
    $content = $content -replace 'EstadoLocales\b', 'StoreStatus'
    $content = $content -replace 'EstadoProblema\b', 'ProblemStatus'
    $content = $content -replace 'UsuarioRoles\b', 'UserRole'
    
    # Rename DTO classes
    $content = $content -replace 'LoginUsuarioRequest\b', 'LoginRequest'
    $content = $content -replace 'LoginUsuarioResponse\b', 'LoginResponse'
    $content = $content -replace 'RegisterUsuarioRequest\b', 'RegisterRequest'
    $content = $content -replace 'ComentarioRequest\b', 'CommentRequest'
    $content = $content -replace 'DecisionLocalesDTO\b', 'StoreDecisionDTO'
    
    # Rename exception classes
    $content = $content -replace 'ResourceNotFoundException', 'ResourceNotFound'
    $content = $content -replace 'GlobalExceptionHandler', 'GlobalExceptionHandler'
    
    # Rename table and entity references
    $content = $content -replace '@Table\(name = "administrador"\)', '@Table(name = "administrator")'
    $content = $content -replace '@Table\(name = "usuario"\)', '@Table(name = "user")'
    $content = $content -replace '@Table\(name = "locales"\)', '@Table(name = "store")'
    $content = $content -replace '@Table\(name = "problemas"\)', '@Table(name = "problem")'
    $content = $content -replace '@Table\(name = "areas_verdes"\)', '@Table(name = "green_area")'
    $content = $content -replace '@Table\(name = "comentario"\)', '@Table(name = "comment")'
    
    # Column name translations
    $content = $content -replace '@Column\(name = "id_administrador"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "id_usuario"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "id_problema"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "id_area"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "id_comentario"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "id_locales"\)', '@Column(name = "id")'
    $content = $content -replace '@Column\(name = "correo"\)', '@Column(name = "email")'
    $content = $content -replace '@Column\(name = "contrasena"\)', '@Column(name = "password")'
    $content = $content -replace '@Column\(name = "edad"\)', '@Column(name = "age")'
    $content = $content -replace '@Column\(name = "nombre"\)', '@Column(name = "name")'
    $content = $content -replace '@Column\(name = "apellido"\)', '@Column(name = "last_name")'
    $content = $content -replace '@Column\(name = "identificador"\)', '@Column(name = "identifier")'
    $content = $content -replace '@Column\(name = "direccion"\)', '@Column(name = "address")'
    $content = $content -replace '@Column\(name = "nombre_usuario"\)', '@Column(name = "first_name")'
    $content = $content -replace '@Column\(name = "apellido_usuario"\)', '@Column(name = "last_name")'
    $content = $content -replace '@Column\(name = "handle_usuario"\)', '@Column(name = "user_handle")'
    $content = $content -replace '@Column\(name = "email_usuario"\)', '@Column(name = "email")'
    $content = $content -replace '@Column\(name = "edad_usuario"\)', '@Column(name = "age")'
    $content = $content -replace '@Column\(name = "rol_usuario"\)', '@Column(name = "role")'
    $content = $content -replace '@Column\(name = "notificacion"\)', '@Column(name = "notification")'
    $content = $content -replace '@Column\(name = "fecha_comentario"\)', '@Column(name = "comment_date")'
    $content = $content -replace '@Column\(name = "nombre_area"\)', '@Column(name = "area_name")'
    $content = $content -replace '@Column\(name = "tipo_area"\)', '@Column(name = "area_type")'
    $content = $content -replace '@Column\(name = "ubicacion_area"\)', '@Column(name = "area_location")'
    $content = $content -replace '@Column\(name = "estado_area"\)', '@Column(name = "area_status")'
    $content = $content -replace '@Column\(name = "motivo_rechazo"\)', '@Column(name = "rejection_reason")'
    $content = $content -replace '@Column\(name = "direccion_asociada"\)', '@Column(name = "associated_address")'
    $content = $content -replace '@Column\(name = "id_categoria"\)', '@Column(name = "category_id")'
    
    # Request mapping and endpoint translations
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/admin"\)', '@RequestMapping("/api/admin")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/usuario"\)', '@RequestMapping("/api/user")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/auth"\)', '@RequestMapping("/api/auth")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/problem"\)', '@RequestMapping("/api/problem")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/locales"\)', '@RequestMapping("/api/store")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/areasVerdes"\)', '@RequestMapping("/api/green-area")'
    $content = $content -replace '@RequestMapping\("\$dichoyhecho/comentarios"\)', '@RequestMapping("/api/comment")'
    
    # Remove any remaining Spanish comments for "constructores"
    $content = $content -replace '//constructores', '//constructors'
    
    if ($content -ne $originalContent) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
        $updateCount++
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "`nPhase 3 Translation complete! Updated $updateCount files."
