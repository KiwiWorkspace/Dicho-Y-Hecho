# Enhanced comprehensive translation script - Phase 2
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse
Write-Host "Processing $($javaFiles.Count) Java files for comprehensive translation..."
$updateCount = 0

foreach ($file in $javaFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $originalContent = $content
    
    # Locales entity field names
    $content = $content -replace 'getId_locales\(\)', 'getId()'
    $content = $content -replace 'setId_locales\(', 'setId('
    $content = $content -replace 'getMotivoRechazo\(\)', 'getRejectionReason()'
    $content = $content -replace 'setMotivoRechazo\(', 'setRejectionReason('
    $content = $content -replace 'getDireccion_asociada\(\)', 'getAssociatedAddress()'
    $content = $content -replace 'setDireccion_asociada\(', 'setAssociatedAddress('
    $content = $content -replace 'getId_categoria\(\)', 'getCategoryId()'
    $content = $content -replace 'setId_categoria\(', 'setCategoryId('
    $content = $content -replace 'private Integer id_locales;', 'private Integer id;'
    $content = $content -replace 'private String motivoRechazo;', 'private String rejectionReason;'
    $content = $content -replace 'private String direccion_asociada;', 'private String associatedAddress;'
    $content = $content -replace 'private String id_categoria;', 'private String categoryId;'
    $content = $content -replace 'this\.id_locales =', 'this.id ='
    $content = $content -replace 'this\.motivoRechazo =', 'this.rejectionReason ='
    $content = $content -replace 'this\.direccion_asociada =', 'this.associatedAddress ='
    $content = $content -replace 'this\.id_categoria =', 'this.categoryId ='
    
    # Problemas entity field names
    $content = $content -replace 'getId_problema\(\)', 'getId()'
    $content = $content -replace 'setId_problema\(', 'setId('
    $content = $content -replace 'getCategoria\(\)', 'getCategory()'
    $content = $content -replace 'setCategoria\(', 'setCategory('
    $content = $content -replace 'getEstado\(\)', 'getStatus()'
    $content = $content -replace 'setEstado\(', 'setStatus('
    $content = $content -replace 'isNotificacion\(\)', 'isNotification()'
    $content = $content -replace 'setNotificacion\(', 'setNotification('
    $content = $content -replace 'private Integer id_problema;', 'private Integer id;'
    $content = $content -replace 'this\.id_problema =', 'this.id ='
    
    # AreasVerdes entity field names
    $content = $content -replace 'getNombreArea\(\)', 'getAreaName()'
    $content = $content -replace 'setNombreArea\(', 'setAreaName('
    $content = $content -replace 'getTipoArea\(\)', 'getAreaType()'
    $content = $content -replace 'setTipoArea\(', 'setAreaType('
    $content = $content -replace 'getUbicacionArea\(\)', 'getAreaLocation()'
    $content = $content -replace 'setUbicacionArea\(', 'setAreaLocation('
    $content = $content -replace 'getEstadoArea\(\)', 'getAreaStatus()'
    $content = $content -replace 'setEstadoArea\(', 'setAreaStatus('
    $content = $content -replace 'private String nombreArea;', 'private String areaName;'
    $content = $content -replace 'private String tipoArea;', 'private String areaType;'
    $content = $content -replace 'private String ubicacionArea;', 'private String areaLocation;'
    $content = $content -replace 'private String estadoArea;', 'private String areaStatus;'
    $content = $content -replace 'this\.nombreArea =', 'this.areaName ='
    $content = $content -replace 'this\.tipoArea =', 'this.areaType ='
    $content = $content -replace 'this\.ubicacionArea =', 'this.areaLocation ='
    $content = $content -replace 'this\.estadoArea =', 'this.areaStatus ='
    
    # Comentarios entity field names
    $content = $content -replace 'getIdComentario\(\)', 'getId()'
    $content = $content -replace 'setIdComentario\(', 'setId('
    $content = $content -replace 'getFechaComentario\(\)', 'getCommentDate()'
    $content = $content -replace 'setFechaComentario\(', 'setCommentDate('
    $content = $content -replace 'getIdUsuario\(\)', 'getUser()'
    $content = $content -replace 'setIdUsuario\(', 'setUser('
    $content = $content -replace 'getContenido\(\)', 'getContent()'
    $content = $content -replace 'setContenido\(', 'setContent('
    $content = $content -replace 'private long idComentario;', 'private long id;'
    $content = $content -replace 'private LocalDateTime fechaComentario;', 'private LocalDateTime commentDate;'
    $content = $content -replace 'private Usuario idUsuario;', 'private Usuario user;'
    $content = $content -replace 'private String contenido;', 'private String content;'
    $content = $content -replace 'this\.idComentario =', 'this.id ='
    $content = $content -replace 'this\.fechaComentario =', 'this.commentDate ='
    $content = $content -replace 'this\.idUsuario =', 'this.user ='
    $content = $content -replace 'this\.contenido =', 'this.content ='
    
    # Service method names - listar → list, crear → create, obtener → get, actualizar → update, eliminar → delete
    $content = $content -replace '\blistar\b', 'list'
    $content = $content -replace '\bcrear\b', 'create'
    $content = $content -replace '\bobtener\b', 'get'
    $content = $content -replace '\bactualizar\b', 'update'
    $content = $content -replace '\beliminar\b', 'delete'
    $content = $content -replace '\baprobar\b', 'approve'
    $content = $content -replace '\brechazar\b', 'reject'
    $content = $content -replace '\blistarPendientes\b', 'listPending'
    $content = $content -replace '\blistarTodos\b', 'listAll'
    $content = $content -replace '\bbuscarPorId\b', 'findById'
    $content = $content -replace '\benviarConfirmacion\b', 'sendConfirmation'
    $content = $content -replace '\bObtenerPorId\b', 'GetById'
    $content = $content -replace '\bObtener\b', 'Get'
    
    # More field name mapping in constructors and initialization
    $content = $content -replace 'idAdministrador', 'id'
    $content = $content -replace 'idUsuario', 'userId'
    $content = $content -replace 'idArea', 'id'
    $content = $content -replace 'fechaComentario', 'commentDate'
    $content = $content -replace 'nombreArea', 'areaName'
    $content = $content -replace 'tipoArea', 'areaType'
    $content = $content -replace 'ubicacionArea', 'areaLocation'
    $content = $content -replace 'estadoArea', 'areaStatus'
    $content = $content -replace 'id_locales', 'id'
    $content = $content -replace 'id_problema', 'id'
    $content = $content -replace 'idComentario', 'commentId'
    $content = $content -replace 'id_usuario', 'userId'
    $content = $content -replace 'id_area', 'areaId'
    $content = $content -replace 'id_categoria', 'categoryId'
    $content = $content -replace 'direccion_asociada', 'associatedAddress'
    $content = $content -replace 'motivo_rechazo', 'rejection_reason'
    $content = $content -replace 'nombre_area', 'area_name'
    $content = $content -replace 'tipo_area', 'area_type'
    $content = $content -replace 'ubicacion_area', 'area_location'
    $content = $content -replace 'estado_area', 'area_status'
    $content = $content -replace 'handle_usuario', 'user_handle'
    $content = $content -replace 'nombre_usuario', 'first_name'
    $content = $content -replace 'apellido_usuario', 'last_name'
    $content = $content -replace 'email_usuario', 'email'
    $content = $content -replace 'edad_usuario', 'age'
    $content = $content -replace 'rol_usuario', 'role'
    
    # Translate class names in imports and usage
    $content = $content -replace 'nombreUsuario', 'firstName'
    $content = $content -replace 'apellidoUsuario', 'lastName'
    $content = $content -replace 'handleUsuario', 'userHandle'
    $content = $content -replace 'emailUsuario', 'email'
    $content = $content -replace 'edadUsuario', 'age'
    $content = $content -replace 'rolUsuario', 'userRole'
    $content = $content -replace 'contrasena', 'password'
    
    # Directorio/Dirección→Address translations in variable names and imports
    $content = $content -replace '\bdirecccion\b', 'address'
    $content = $content -replace 'direcci[oó]n', 'address'
    
    if ($content -ne $originalContent) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
        $updateCount++
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "`nPhase 2 Translation complete! Updated $updateCount files."
