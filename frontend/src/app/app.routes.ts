import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './components/page-not-found-component/page-not-found-component';
import { LoginComponent } from './components/login-component/login-component';
import { HomeComponent } from './components/home-component/home-component';
import { loggedinGuard } from './guards/loggedin-guard';
import { ContainerMany } from './components/container/container-many/container-many';
import { rolesGuard } from './guards/role-guard';
import { ContainerDetail } from './components/container/container-detail/container-detail';
import { ContainerForm } from './components/container/container-form/container-form';

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent,
        canActivate: [loggedinGuard]
    },
    {
        path: "",
        component: HomeComponent,
        canActivate: [loggedinGuard]
    },
    // Containers
    {
        path: "containers",
        component: ContainerMany,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "containers/new",
        component: ContainerForm,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "containers/:id",
        component: ContainerDetail,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "containers/:id/edit",
        component: ContainerForm,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    // ==========
    {
        path: "**",
        component: PageNotFoundComponent
    }
];
