# Rename Java files to match their new class names
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

$renames = @{
    "Administrador.java" = "Administrator.java"
    "Locales.java" = "Store.java"
    "Problemas.java" = "Problem.java"
    "AreasVerdes.java" = "GreenArea.java"
    "Comentarios.java" = "Comment.java"
    "AutenController.java" = "AuthController.java"
    "AutenService.java" = "AuthService.java"
    "CorreoService.java" = "EmailService.java"
    "AdministradorService.java" = "AdministratorService.java"
    "AdministradorServiceImpl.java" = "AdministratorServiceImpl.java"
    "LocalesService.java" = "StoreService.java"
    "LocalesServiceImpl.java" = "StoreServiceImpl.java"
    "ProblemasService.java" = "ProblemService.java"
    "ProblemasServiceImpl.java" = "ProblemServiceImpl.java"
    "AreasVerdesService.java" = "GreenAreaService.java"
    "AreasVerdesServiceImpl.java" = "GreenAreaServiceImpl.java"
    "AreasVerdesRepository.java" = "GreenAreaRepository.java"
    "AreasVerdesController.java" = "GreenAreaController.java"
    "AdministradorRepository.java" = "AdministratorRepository.java"
    "LocalesRepository.java" = "StoreRepository.java"
    "ProblemasRepository.java" = "ProblemRepository.java"
    "ComentariosRepository.java" = "CommentRepository.java"
    "AdministradorController.java" = "AdministratorController.java"
    "LocalesController.java" = "StoreController.java"
    "LocalesAdminController.java" = "AdminStoreController.java"
    "ProblemasController.java" = "ProblemController.java"
    "ComentarioController.java" = "CommentController.java"
    "CategoriaProblema.java" = "ProblemCategory.java"
    "EstadoLocales.java" = "StoreStatus.java"
    "EstadoProblema.java" = "ProblemStatus.java"
    "UsuarioRoles.java" = "UserRole.java"
    "LoginUsuarioRequest.java" = "LoginRequest.java"
    "LoginUsuarioResponse.java" = "LoginResponse.java"
    "RegisterUsuarioRequest.java" = "RegisterRequest.java"
    "ComentarioRequest.java" = "CommentRequest.java"
    "DecisionLocalesDTO.java" = "StoreDecisionDTO.java"
    "ResourceNotFoundException.java" = "ResourceNotFound.java"
}

Write-Host "Renaming Java files..."
$renameCount = 0

foreach ($oldName in $renames.Keys) {
    $newName = $renames[$oldName]
    
    # Find files recursively
    $files = Get-ChildItem -Path $sourceDir -Filter $oldName -Recurse -ErrorAction SilentlyContinue
    
    foreach ($file in $files) {
        $newPath = Join-Path -Path $file.Directory.FullName -ChildPath $newName
        
        # Check if file already exists
        if (Test-Path $newPath) {
            Write-Host "Skipping: $oldName (destination exists)"
        } else {
            Rename-Item -Path $file.FullName -NewName $newName
            Write-Host "Renamed: $oldName → $newName"
            $renameCount++
        }
    }
}

Write-Host "`nFile renaming complete! Renamed $renameCount files."
