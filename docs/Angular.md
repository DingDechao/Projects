# Angular
## Environment setop
1. Install nodejs
   - Download nodejs from https://nodejs.org/en/
   - The latest version is 18.12.1 LTS as of 2023/01/01
2. Check nodejs and npm versiom
     ```
   node --version or node -v
   v18.12.1
   npm -v
   8.19.2
    ```
3. Install typescript
    ```
   switch to root user
   sudo su - root
   npm install -g typescript
   ```
4. Install angular/cli
    ```
   npm install -g @angular/cli
   ```
   ```
    Check version
   ng version
    ```
5. Create angular project
    ```
   ng new balance-sheet-ui
   ```

6. Run angular project
    ```
   ng serve
   ```
7. Open Angular application from Chrome
    ```
   http://localhost:4200/
   ```
6. Generate new component
    ```
   ng generate component balance-sheet-ui/balance-sheet-ui-item
   ```