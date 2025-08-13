import ProtectedRoute from './ProtectedRoute';
import { createBrowserRouter } from 'react-router';
import { lazy } from 'react';
import { groupDetailsLoader } from '../pages/Groups/GroupDetails/groupDetailsLoader';
import { loginAction } from '../actions/loginAction';
import { registerAction } from '../actions/registerAction';
import { groupAction } from '../actions/groupAction';
import { groupSettingsLoader } from '../pages/Groups/GroupDetails/GroupSettings/groupSettingsLoader';

const App = lazy(() => import('../App'));
const Layout = lazy(() => import('../components/Layout'));
const Login = lazy(() => import('../pages/Login'));
const Register = lazy(() => import('../pages/Register'));
const Dashboard = lazy(() => import('../pages/Dashboard'));
const Groups = lazy(() => import('../pages/Groups'));
const GroupDetails = lazy(() => import('../pages/Groups/GroupDetails'));
const Profile = lazy(() => import('../pages/Profile'));
const GroupSettings = lazy(
  () => import('../pages/Groups/GroupDetails/GroupSettings')
);
const NotFound = lazy(() => import('../pages/Notfound'));
export const routes = createBrowserRouter([
  // Rotas públicas (login e registro)
  {
    element: <Layout />,
    children: [
      { path: '/login', element: <Login />, action: loginAction },
      { path: '/register', element: <Register />, action: registerAction },
    ],
  },
  // Rotas privadas (todas as outras)
  {
    path: '/',
    element: <ProtectedRoute />, // <== Aqui é onde protegemos tudo
    errorElement: <NotFound />,
    children: [
      {
        element: <Layout />,
        children: [
          { index: true, element: <App /> }, // Redirecionamento ou página inicial
          { path: 'dashboard', element: <Dashboard /> },
          {
            path: 'groups',
            children: [
              { index: true, element: <Groups />, action: groupAction },
              {
                path: ':group-id',
                element: <GroupDetails />,
                loader: groupDetailsLoader,
              },
              {
                path: ':group-id/settings',
                element: <GroupSettings />,
                loader: groupSettingsLoader,
              },
            ],
          },
          { path: 'profile', element: <Profile /> },
        ],
      },
    ],
  },
]);
