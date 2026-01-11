@echo off
title FernanPop - Instalador y Ejecutor
setlocal

:: Limpiar pantalla y mostrar bienvenida
cls
echo ==================================================
echo           BIENVENIDO A FERNANPOP
echo ==================================================
echo.

:: 1. Comprobar si Java esta instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] No se encontro Java instalado en este sistema.
    echo Por favor, instala el JDK de Java para continuar.
    pause
    exit /b
)

:: 2. Crear carpeta para los archivos compilados (limpia)
if exist bin rd /s /q bin
mkdir bin

echo Compilando el proyecto...

:: 3. Compilar el proyecto manteniendo la estructura de paquetes
:: Compila modelos y la vista principal
javac -d bin models/*.java view/Main.java

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Hubo un error durante la compilacion.
    pause
    exit /b
)

echo [OK] Compilacion exitosa.
echo Iniciando aplicacion...
echo.

:: 4. Ejecutar la aplicacion desde la carpeta bin
:: Se usa el paquete view y la clase Main
java -cp bin view.Main

echo.
echo ==================================================
echo   Gracias por usar FernanPop. Presiona una tecla.
echo ==================================================
pause