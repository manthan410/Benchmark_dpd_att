@echo off
setlocal enabledelayedexpansion

REM Define the ProGuard configuration file and JAR name
set PROGUARD_CONFIG_FILE=config.pro
set JAR_NAME=app.jar

REM Loop through all directories starting with "obfu"
for /d %%D in (obfu*) do (
    REM Check if the "bin" subdirectory exists
    if exist "%%D\bin" (
        echo Processing directory: %%D

        REM Navigate to the bin directory and create the JAR file
        pushd %%D\bin
        jar cf ..\%JAR_NAME% .
        popd

        REM Copy the ProGuard configuration file if it doesn't already exist
        if not exist "%%D\%PROGUARD_CONFIG_FILE%" (
            echo Adding %PROGUARD_CONFIG_FILE% to %%D
            copy %PROGUARD_CONFIG_FILE% "%%D\"
        ) else (
            echo %PROGUARD_CONFIG_FILE% already exists in %%D
        )

        REM Navigate to the directory and run ProGuard
        pushd %%D
        echo Running ProGuard in %%D
        proguard @%PROGUARD_CONFIG_FILE%
        popd
    ) else (
        echo Skipping directory: %%D (no 'bin' directory found)
    )
)

echo Script execution completed.
pause
