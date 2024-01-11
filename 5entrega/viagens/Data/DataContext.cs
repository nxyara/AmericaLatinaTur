using Viagens.Model;
using Microsoft.EntityFrameworkCore;

namespace Viagens.Data
{

    public class DataContext : DbContext
    {



    public DataContext(DbContextOptions<DataContext> options) : base(options)
    {
    }


    public DbSet<Viagem> Viagens { get ; set; }

        
protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
 
            modelBuilder.Entity<Viagem>().HasData(
                new Viagem { Id = 1, Name = "Machu Pichu", Genre = "Pacote", Price = 5000, viagemURL = "https://lh3.googleusercontent.com/p/AF1QipO2NIzSUwUjtU7MAWsML_F6ft7UfPAX1sttz_C2=s680-w680-h510" },
                new Viagem { Id = 2, Name = "Cartagena", Genre = "Pacote", Price = 6000, viagemURL = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcTw6KTTQf36P9IjnV2Ore8beWC7AN9ZjZPlw15UV0LRVBVt9IRGySmSqJ5pwaJn7-Wm78NhefuTF0hIxz-b7obVxOLy_QafdzH8Xs9d3Q" },
                new Viagem { Id = 3, Name = "Torres del Paine", Genre = "Pacote", Price = 7000, viagemURL = "https://lh3.googleusercontent.com/p/AF1QipNL8lmndfwsn2cha4t9K0FUPmfFqUooqWpsXXHd=s680-w680-h510" },
                new Viagem { Id = 4, Name = "Laguna Colorada", Genre = "Pacote", Price = 8000, viagemURL = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRRHt-d6dHsz9HzY1AZXtv8aNRQel2gFvzT5ZSUAd0SGvMEyZf2e5pH4rciW0S7XpAHDICZ-ba8WQDuDAM0iWvnNWqhaP_nTtuRQ8qYLA" }
            );
        }
        }

    }
    