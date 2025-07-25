import CardUI from '../../components/ui/Card';
import { mockGroups } from './mockGroups';

export default function Groups() {
  return (
    <div className="flex flex-col md:flex-row min-h-screen">
      <main className="flex-1 p-4">
        <div className="flex items-center justify-between mb-4">
          <h1 className="text-xl font-bold text-center md:hidden">
            Meus grupos
          </h1>
        </div>
        <h2 className="text-2xl font-bold mb-4 hidden md:block">Meus grupos</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-4">
          {mockGroups.map((group, idx) => (
            <a href={`/groups/${group.id}`}>
              <CardUI
                className={
                  ' opacity-60 hover:opacity-100 transition-opacity cursor-pointer border rounded-lg p-4 shadow-sm bg-white'
                }
                key={idx}
              >
                <div className="flex items-center gap-2 mb-2 text-lg">
                  <span>{group.icon}</span>
                  <h3 className="font-semibold">{group.name}</h3>
                </div>
                <p className="text-sm text-gray-600 mb-2">
                  {group.members.length} Membros
                </p>

                <div className="relative h-6 w-[calc(1.5rem+0.5rem*number_of_members)]">
                  {group.members.map((m, idx) => (
                    <span
                      key={idx}
                      className="bg-blue-600 text-white text-sm w-6 h-6 rounded-full flex items-center justify-center absolute border border-black shadow-sm shadow-gray-600"
                      style={{
                        left: `${idx * 1.2}rem`, // desloca para a direita
                        zIndex: group.members.length - idx, // mais à esquerda, mais acima
                      }}
                    >
                      {m[0]}
                    </span>
                  ))}
                </div>
                <p className={`text-sm font-semibold ${group.statusColor}`}>
                  {group.status}
                </p>
              </CardUI>
            </a>
          ))}
        </div>
      </main>
    </div>
  );
}
