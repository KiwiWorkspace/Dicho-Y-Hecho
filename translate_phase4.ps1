# Final Comprehensive Translation - Phase 4
# Translates remaining routes, comments, variables and database

$sourceDir = "d:\KINAL2026\TALLER\GITHUB\Dicho-Y-Hecho\dichoyhecho\dichoyhecho\src\main\java\com\dichoyhecho\dichoyhecho"

$javaFiles = Get-ChildItem -Path $sourceDir -Filter "*.java" -Recurse
Write-Host "Processing $($javaFiles.Count) Java files for final translations..."
$updateCount = 0

foreach ($file in $javaFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $originalContent = $content
    
    # Translate routes and request mappings
    $content = $content -replace '/dichoyhecho/usuario/', '/api/user/'
    $content = $content -replace '/dichoyhecho/comentarios/', '/api/comment/'
    $content = $content -replace '/dichoyhecho/locales/', '/api/store/'
    $content = $content -replace '/dichoyhecho/problema/', '/api/problem/'
    $content = $content -replace '/dichoyhecho/areasVerdes/', '/api/green-area/'
    $content = $content -replace '/dichoyhecho/admin/', '/api/admin/'
    $content = $content -replace '/dichoyhecho/auth/', '/api/auth/'
    
    # Translate parameters and variables
    $content = $content -replace '\badministrador\b', 'administrator'
    $content = $content -replace '\bAdministrador ', 'Administrator '
    $content = $content -replace '\blocar\b', 'location'
    $content = $content -replace '\bidProblema\b', 'problemId'
    $content = $content -replace '\bidLocal\b', 'storeId'
    $content = $content -replace '\bidArea\b', 'areaId'
    $content = $content -replace '\bidComentario\b', 'commentId'
    $content = $content -replace '\bidUsuario\b', 'userId'
    
    # Translate comments
    $content = $content -replace '// Todo lo demás requiere autenticación', '// All other endpoints require authentication'
    $content = $content -replace '//comentarios', '// comments'
    $content = $content -replace '//usuario', '// user'
    $content = $content -replace '//administrador', '// administrator'
    $content = $content -replace '//area', '// area'
    $content = $content -replace '//problema', '// problem'
    
    # Translate more comments
    $content = $content -replace '/\*\*\s*\n\s*\*\s*Comentarios', '/**\n     * Comments'
    $content = $content -replace '// Locales', '// Stores'
    $content = $content -replace '// Problemas', '// Problems'
    $content = $content -replace '// Administrador', '// Administrator'
    $content = $content -replace '// Areas Verdes', '// Green Areas'
    
    # Fix request matcher paths in security config
    $content = $content -replace 'requestMatchers\("/dichoyhecho/', 'requestMatchers("/api/'
    
    if ($content -ne $originalContent) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
        $updateCount++
        Write-Host "Updated: $($file.Name)"
    }
}

Write-Host "`nPhase 4 Translation complete! Updated $updateCount files."
