using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.Entities
{
	public class Context : DbContext
	{
		public DbSet<User> Users { get; set; }
		public DbSet<Record> Records { get; set; }
		public DbSet<Photo> Photos { get; set; }

		public Context(DbContextOptions<Context> options)
			: base(options)
		{
		}

		protected override void OnModelCreating(ModelBuilder modelBuilder)
		{
			base.OnModelCreating(modelBuilder);

			modelBuilder.Entity<User>(entity =>
			{
				// указва, че уникалният ключ е Id
				entity.HasKey(r => r.Id);

				// указва, че стойността се изчислява автоматично, когато се добавя нова Category
				entity.Property(r => r.Id)
					.ValueGeneratedOnAdd();
			});

			modelBuilder.Entity<Record>(entity =>
			{
				entity.HasKey(r => r.Id);

				entity.Property(r => r.Id)
					.ValueGeneratedOnAdd();

				entity
					.HasOne(r => r.User)
					.WithMany(u => u.Records)
					.HasPrincipalKey(u => u.Id)
					.HasForeignKey(r => r.UserId)
					.OnDelete(DeleteBehavior.Restrict);
			});

			modelBuilder.Entity<Photo>(entity =>
			{
				entity.HasKey(r => r.Id);

				entity.Property(r => r.Id)
					.ValueGeneratedOnAdd();

				entity
					.HasOne(p => p.Record)
					.WithOne(r => r.Photo)
					.HasForeignKey<Photo>(b => b.RecordId);
			});
		}
	}
}
