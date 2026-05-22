@ECHO OFF
SETLOCAL EnableExtensions DisableDelayedExpansion
for /F %%a in ('echo prompt $E ^| cmd') do (
  set "ESC=%%a"
)
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo [92m Super cool generator lol[0m
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo.
setlocal enabledelayedexpansion
echo [92mGive the item's ID[0m
set /p "ID_INPUT=> "
echo [92mGive the mod's namespace[0m
set /p "NS_INPUT=> "
echo [92mGive the item's translated name[0m
set /p "NAME=> "
echo.
echo [92mCreating item %ID_INPUT% under namespace %NS_INPUT% and naming it %NAME%...[0m
echo.
echo.
if not exist "assets\%NS_INPUT%\items" mkdir "assets\%NS_INPUT%\items" && echo [92mItems folder created[0m || echo [91merror occured when creating folder[0m
if not exist "assets\%NS_INPUT%\models\item" mkdir "assets\%NS_INPUT%\models\item" && echo [92mModels folder created[0m || echo [91merror occured when creating folder[0m
if not exist "assets\%NS_INPUT%\lang" mkdir "assets\%NS_INPUT%\lang" && echo [92mLang folder created[0m || echo [91merror occured when creating folder[0m
echo Creating assets/%NS_INPUT%/items/%ID_INPUT%.json...
set "TEMPLATE=itemstemp.json"
set "OUTPUT=assets\%NS_INPUT%\items\%ID_INPUT%.json"
(for /f "delims=" %%L in ('type "%TEMPLATE%"') do (
    set "line=%%L"
    set "line=!line:{{NAMESPACE}}=%NS_INPUT%!"
    set "line=!line:{{ID}}=%ID_INPUT%!"
    echo !line!
)) > "%OUTPUT%" && echo [92mCreated item file[0m || echo [91mSomething went wrong...[0m
echo Creating assets/%NS_INPUT%/models/item/%ID_INPUT%.json...
set "TEMPLATE=modelstemp.json"
set "OUTPUT=assets\%NS_INPUT%\models\item\%ID_INPUT%.json"
(for /f "delims=" %%L in ('type "%TEMPLATE%"') do (
    set "line=%%L"
    set "line=!line:{{NAMESPACE}}=%NS_INPUT%!"
    set "line=!line:{{ID}}=%ID_INPUT%!"
    echo !line!
)) > "%OUTPUT%" && echo [92mCreated model file[0m || echo [91mSomething went wrong...[0m
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
)) > %en_usTemp% && echo [92mFound and loaded lang file[0m || echo [91mJson does not exist, make sure the file is not malformed[0m
echo "item.%NS_INPUT%.%ID_INPUT%": "%NAME%", >> %en_usTemp% && echo [92mAdded new entry[0m || echo [91mSomething went wrong while adding new entry[0m
echo "item.null.null": "null" >> %en_usTemp%
echo } >> %en_usTemp%
move /y %en_usTemp% %en_us% && echo [92mMerged new lang file successfully[0m || echo [91mSomething went wrong while merging files[0m

echo.
echo [4m[92mDone![0m


pause