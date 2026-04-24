# Update all imports and class references to match renamed files
$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

$importUpdates = @{
    "import com.dichoyhecho.dichoyhecho.entity.Administrador;" = "import com.dichoyhecho.dichoyhecho.entity.Administrator;"
    "import com.dichoyhecho.dichoyhecho.entity.Locales;" = "import com.dichoyhecho.dichoyhecho.entity.Store;"
    "import com.dichoyhecho.dichoyhecho.entity.Problemas;" = "import com.dichoyhecho.dichoyhecho.entity.Problem;"
    "import com.dichoyhecho.dichoyhecho.entity.AreasVerdes;" = "import com.dichoyhecho.dichoyhecho.entity.GreenArea;"
    "import com.dichoyhecho.dichoyhecho.entity.Comentarios;" = "import com.dichoyhecho.dichoyhecho.entity.Comment;"
    "import com.dichoyhecho.dichoyhecho.enums.CategoriaProblema;" = "import com.dichoyhecho.dichoyhecho.enums.ProblemCategory;"
    "import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;" = "import com.dichoyhecho.dichoyhecho.enums.StoreStatus;"
    "import com.dichoyhecho.dichoyhecho.enums.EstadoProblema;" = "import com.dichoyhecho.dichoyhecho.enums.ProblemStatus;"
    "import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;" = "import com.dichoyhecho.dichoyhecho.enums.UserRole;"
    "import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioRequest;" = "import com.dichoyhecho.dichoyhecho.dto.LoginRequest;"
    "import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioResponse;" = "import com.dichoyhecho.dichoyhecho.dto.LoginResponse;"
    "import com.dichoyhecho.dichoyhecho.dto.RegisterUsuarioRequest;" = "import com.dichoyhecho.dichoyhecho.dto.RegisterRequest;"
    "import com.dichoyhecho.dichoyhecho.dto.ComentarioRequest;" = "import com.dichoyhecho.dichoyhecho.dto.CommentRequest;"
    "import com.dichoyhecho.dichoyhecho.dto.DecisionLocalesDTO;" = "import com.dichoyhecho.dichoyhecho.dto.StoreDecisionDTO;"
    "import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;" = "import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;"
    "import com.dichoyhecho.dichoyhecho.service.AdministradorService;" = "import com.dichoyhecho.dichoyhecho.service.AdministratorService;"
    "import com.dichoyhecho.dichoyhecho.service.LocalesService;" = "import com.dichoyhecho.dichoyhecho.service.StoreService;"
    "import com.dichoyhecho.dichoyhecho.service.ProblemasService;" = "import com.dichoyhecho.dichoyhecho.service.ProblemService;"
    "import com.dichoyhecho.dichoyhecho.service.AreasVerdesService;" = "import com.dichoyhecho.dichoyhecho.service.GreenAreaService;"
    "import com.dichoyhecho.dichoyhecho.service.AutenService;" = "import com.dichoyhecho.dichoyhecho.service.AuthService;"
    "import com.dichoyhecho.dichoyhecho.service.CorreoService;" = "import com.dichoyhecho.dichoyhecho.service.EmailService;"
    "import com.dichoyhecho.dichoyhecho.repository.AdministradorRepository;" = "import com.dichoyhecho.dichoyhecho.repository.AdministratorRepository;"
    "import com.dichoyhecho.dichoyhecho.repository.LocalesRepository;" = "import com.dichoyhecho.dichoyhecho.repository.StoreRepository;"
    "import com.dichoyhecho.dichoyhecho.repository.ProblemasRepository;" = "import com.dichoyhecho.dichoyhecho.repository.ProblemRepository;"
    "import com.dichoyhecho.dichoyhecho.repository.ComentariosRepository;" = "import com.dichoyhecho.dichoyhecho.repository.CommentRepository;"
    "import com.dichoyhecho.dichoyhecho.repository.AreasVerdesRepository;" = "import com.dichoyhecho.dichoyhecho.repository.GreenAreaRepository;"
}

$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse
Write-Host "Updating imports and class references in $($javaFiles.Count) files..."
$updateCount = 0

foreach ($file in $javaFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $originalContent = $content
    
    # Update imports
    foreach ($oldImport in $importUpdates.Keys) {
        $newImport = $importUpdates[$oldImport]
        $content = $content -replace [regex]::Escape($oldImport), $newImport
    }
    
    # Update constructor calls and type declarations
    $content = $content -replace 'new Administrador\(', 'new Administrator('
    $content = $content -replace 'new Locales\(', 'new Store('
    $content = $content -replace 'new Problemas\(', 'new Problem('
    $content = $content -replace 'new AreasVerdes\(', 'new GreenArea('
    $content = $content -replace 'new Comentarios\(', 'new Comment('
    $content = $content -replace '<Administrador>', '<Administrator>'
    $content = $content -replace '<Locales>', '<Store>'
    $content = $content -replace '<Problemas>', '<Problem>'
    $content = $content -replace '<AreasVerdes>', '<GreenArea>'
    $content = $content -replace '<Comentarios>', '<Comment>'
    $content = $content -replace 'Administrador ', 'Administrator '
    $content = $content -replace 'Locales ', 'Store '
    $content = $content -replace 'Problemas ', 'Problem '
    $content = $content -replace 'AreasVerdes ', 'GreenArea '
    $content = $content -replace 'Comentarios ', 'Comment '
    
    # Update repository type references
    $content = $content -replace 'AdministradorRepository ', 'AdministratorRepository '
    $content = $content -replace 'LocalesRepository ', 'StoreRepository '
    $content = $content -replace 'ProblemasRepository ', 'ProblemRepository '
    $content = $content -replace 'ComentariosRepository ', 'CommentRepository '
    $content = $content -replace 'AreasVerdesRepository ', 'GreenAreaRepository '
    
    # Update service references
    $content = $content -replace 'AdministradorService ', 'AdministratorService '
    $content = $content -replace 'LocalesService ', 'StoreService '
    $content = $content -replace 'ProblemasService ', 'ProblemService '
    $content = $content -replace 'AreasVerdesService ', 'GreenAreaService '
    $content = $content -replace 'AutenService ', 'AuthService '
    $content = $content -replace 'CorreoService ', 'EmailService '
    
    # Update exception references
    $content = $content -replace 'ResourceNotFoundException', 'ResourceNotFound'
    
    # Update enum references (already done but make sure)
    $content = $content -replace 'CategoriaProblema\.', 'ProblemCategory.'
    $content = $content -replace 'EstadoLocales\.', 'StoreStatus.'
    $content = $content -replace 'EstadoProblema\.', 'ProblemStatus.'
    $content = $content -replace 'UsuarioRoles\.', 'UserRole.'
    
    if ($content -ne $originalContent) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
        $updateCount++
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "`nImport and reference updates complete! Updated $updateCount files."
