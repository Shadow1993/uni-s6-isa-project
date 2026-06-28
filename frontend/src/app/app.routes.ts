import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './components/page-not-found-component/page-not-found-component';
import { LoginComponent } from './components/login-component/login-component';
import { HomeComponent } from './components/home-component/home-component';
import { loggedinGuard } from './guards/loggedin-guard';
import { ContainerMany } from './components/container/container-many/container-many';
import { rolesGuard } from './guards/role-guard';
import { ContainerDetail } from './components/container/container-detail/container-detail';
import { ContainerForm } from './components/container/container-form/container-form';
import { NodeMany } from './components/node/node-many/node-many';
import { NodeForm } from './components/node/node-form/node-form';
import { NodeDetail } from './components/node/node-detail/node-detail';
import { ClusterMany } from './components/cluster/cluster-many/cluster-many';
import { ClusterForm } from './components/cluster/cluster-form/cluster-form';
import { ClusterDetail } from './components/cluster/cluster-detail/cluster-detail';
import { ImageMany } from './components/image/image-many/image-many';
import { ImageForm } from './components/image/image-form/image-form';
import { ImageDetail } from './components/image/image-detail/image-detail';
import { UserMany } from './components/user/user-many/user-many';
import { UserForm } from './components/user/user-form/user-form';
import { UserDetail } from './components/user/user-detail/user-detail';
import { RegisterComponent } from './components/register-component/register-component';
import { ChangepasswordComponent } from './components/changepassword-component/changepassword-component';

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent,
        canActivate: [loggedinGuard]
    },
    {
        path: "register",
        component: RegisterComponent,
        canActivate: [loggedinGuard]
    },
    {
        path: "",
        component: HomeComponent,
        canActivate: [loggedinGuard]
    },
    {
        path: "changepassword",
        component: ChangepasswordComponent,
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
    // Nodes
    {
        path: "nodes",
        component: NodeMany,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    {
        path: "nodes/new",
        component: NodeForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    {
        path: "nodes/:id",
        component: NodeDetail,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    {
        path: "nodes/:id/edit",
        component: NodeForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    // ==========
    // Clusters
    {
        path: "clusters",
        component: ClusterMany,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "clusters/new",
        component: ClusterForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    {
        path: "clusters/:id",
        component: ClusterDetail,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "clusters/:id/edit",
        component: ClusterForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    // ==========
    // Images
    {
        path: "images",
        component: ImageMany,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "images/new",
        component: ImageForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    {
        path: "images/:id",
        component: ImageDetail,
        data: {"roles": ["ADMIN", "USER"]},
        canActivate:[rolesGuard]
    },
    {
        path: "images/:id/edit",
        component: ImageForm,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    // ==========
    // Users
    {
        path: "users",
        component: UserMany,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    // not implemented
    // {
    //     path: "users/new",
    //     component: UserForm,
    //     data: {"roles": ["ADMIN"]},
    //     canActivate:[rolesGuard]
    // },
    {
        path: "users/:id",
        component: UserDetail,
        data: {"roles": ["ADMIN"]},
        canActivate:[rolesGuard]
    },
    // not implemented
    // {
    //     path: "users/:id/edit",
    //     component: UserForm,
    //     data: {"roles": ["ADMIN"]},
    //     canActivate:[rolesGuard]
    // },
    // ==========

    {
        path: "**",
        component: PageNotFoundComponent
    }
];
