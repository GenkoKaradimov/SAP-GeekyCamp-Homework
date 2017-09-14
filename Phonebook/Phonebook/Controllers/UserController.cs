using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Phonebook.Entities;
using Phonebook.ViewModels.User;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.Controllers
{
	public class UserController : Controller
	{
		private readonly Context _context;

		public UserController(Context context)
		{
			_context = context;
		}

		[HttpGet]
		public IActionResult Index()
		{
			return RedirectToAction("Profile");
		}

		[HttpGet]
		public IActionResult Home()
		{
			return View();
		}

		[HttpGet]
		public IActionResult Login()
		{
			return View();
		}

		[HttpPost]
		public IActionResult Login(LoginViewModel model)
		{
			var user = _context.Users.FirstOrDefault(x => x.Email == model.Email && x.Password == model.Password);

			if (user == null)
				return View();

			HttpContext.Session.SetString("UserId", user.Id.ToString());

			return RedirectToAction("Index", "Record");
		}

		[HttpGet]
		public IActionResult Register()
		{
			return View();
		}

		[HttpPost]
		public IActionResult Register(RegisterViewModel model)
		{
			var user = new Entities.User()
			{
				Email = model.Email,
				Password = model.Password
			};

			_context.Users.Add(user);
			_context.SaveChanges();

			HttpContext.Session.SetString("UserId", user.Id.ToString());

			return RedirectToAction("Index", "Record");
		}

		[HttpGet]
		public IActionResult Profile()
		{
			int id = int.Parse(HttpContext.Session.GetString("UserId"));
			Entities.User user = _context.Users.FirstOrDefault(x => x.Id == id);

			if (user == null)
				return RedirectToAction("Login");

			// todo - da se pokazva profilna stranica
			return View();
		}

		// 
		// HttpContext.Session.SetString(Id, "Rick");
		//  var name = HttpContext.Session.GetString(SessionKeyName);
	}
}
