@echo off
setlocal enabledelayedexpansion
set "NS_INPUT=%~1"
set "ID_INPUT=%~2"
set "NAME=%~3"
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo      SUPER COOL PROGRAM THAT LETS YOU DO COOL STUFF AND SAVE ALOT OF TIME
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo.

echo Creating assets/%NS_INPUT%/items/%ID_INPUT%.json...
set "TEMPLATE=itemstemp.json"
set "OUTPUT=assets\%NS_INPUT%\items\%ID_INPUT%.json"
(for /f "delims=" %%L in ('type "%TEMPLATE%"') do (
    set "line=%%L"
    set "line=!line:{{NAMESPACE}}=%NS_INPUT%!"
    set "line=!line:{{ID}}=%ID_INPUT%!"
    echo !line!
)) > "%OUTPUT%"
echo Created item file
echo Creating assets/%NS_INPUT%/models/item/%ID_INPUT%.json...
set "TEMPLATE=modelstemp.json"
set "OUTPUT=assets\%NS_INPUT%\models\item\%ID_INPUT%.json"
(for /f "delims=" %%L in ('type "%TEMPLATE%"') do (
    set "line=%%L"
    set "line=!line:{{NAMESPACE}}=%NS_INPUT%!"
    set "line=!line:{{ID}}=%ID_INPUT%!"
    echo !line!
)) > "%OUTPUT%"
echo Created model file
echo Adding translation entry...
set "en_us=assets\%NS_INPUT%\lang\en_us.json"
set "en_usTemp=assets\%NS_INPUT%\lang\en_usTemp.json"

set "totalLines=0"
for /f "tokens=*" %%a in (%en_us%) do set /a totalLines+=1

set /a linesToKeep=%totalLines%-2
set "currentLine=0"

(for /f "tokens=*" %%a in (%en_us%) do (
    set /a currentLine+=1
    if !currentLine! leq %linesToKeep% (
        echo %%a
    )
)) > %en_usTemp%
echo "item.%NS_INPUT%.%ID_INPUT%": "%NAME%", >> %en_usTemp%

echo "item.null.null": "null" >> %en_usTemp%
echo } >> %en_usTemp%
move /y %en_usTemp% %en_us%
echo Translation entry added
echo.
echo Done
exit
