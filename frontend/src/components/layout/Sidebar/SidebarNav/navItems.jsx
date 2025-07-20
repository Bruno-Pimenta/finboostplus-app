import { ImHome } from 'react-icons/im';
import { MdDashboard, MdGroups } from 'react-icons/md';
import { FaUser } from 'react-icons/fa';
import { TbLogout2 } from 'react-icons/tb';
export const navItems = [
  { icon: <ImHome />, label: 'Início', href: '/' },
  { icon: <MdDashboard />, label: 'Despesas', href: '/expenses' },
  { icon: <MdGroups />, label: 'Grupos', href: '/groups' },
  { icon: <FaUser />, label: 'Perfil', href: '/profile' },
  {
    icon: <TbLogout2 />,
    label: 'Sair',
    href: '/login',
    className: 'text-red-500 font-bold',
  },
];
