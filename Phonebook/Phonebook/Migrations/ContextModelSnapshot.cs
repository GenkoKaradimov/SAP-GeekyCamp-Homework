using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Phonebook.Entities;

namespace Phonebook.Migrations
{
    [DbContext(typeof(Context))]
    partial class ContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "1.1.2")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Phonebook.Entities.Photo", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<byte[]>("Content");

                    b.Property<string>("PhotoType");

                    b.Property<int>("RecordId");

                    b.HasKey("Id");

                    b.HasIndex("RecordId")
                        .IsUnique();

                    b.ToTable("Photos");
                });

            modelBuilder.Entity("Phonebook.Entities.Record", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DateCreated");

                    b.Property<string>("FirstName");

                    b.Property<string>("Name");

                    b.Property<string>("Phone");

                    b.Property<int>("PhotoId");

                    b.Property<string>("SecondName");

                    b.Property<int>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("UserId");

                    b.ToTable("Records");
                });

            modelBuilder.Entity("Phonebook.Entities.User", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Email");

                    b.Property<string>("Password");

                    b.HasKey("Id");

                    b.ToTable("Users");
                });

            modelBuilder.Entity("Phonebook.Entities.Photo", b =>
                {
                    b.HasOne("Phonebook.Entities.Record", "Record")
                        .WithOne("Photo")
                        .HasForeignKey("Phonebook.Entities.Photo", "RecordId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("Phonebook.Entities.Record", b =>
                {
                    b.HasOne("Phonebook.Entities.User", "User")
                        .WithMany("Records")
                        .HasForeignKey("UserId");
                });
        }
    }
}
