import React from "react";

function App() {
  return (
    <div>
      <header>
        <h1>My Portfolio</h1>
        <nav>
          <a href="#home">Home</a>{" "}
          <a href="#about">About</a>{" "}
          <a href="#skills">Skills</a>{" "}
          <a href="#projects">Projects</a>{" "}
          <a href="#contact">Contact</a>
        </nav>
      </header>

      <section id="home">
        <h2>Hello, I'm Kanishka,a Student Developer</h2>
        <p>Welcome to my personal portfolio.</p>
      </section>

      <section id="about">
        <h2>About Me</h2>
        <p>Hello! I am an engineering student with an interest in technology, programming, and web development. I enjoy learning new skills, solving problems, and building creative projects. My goal is to improve my technical knowledge and use it to develop useful solutions..</p>
      </section>

      <section id="skills">
        <h2>My Skills</h2>
        <p>HTML, CSS, JavaScript, React and Java</p>
      </section>

      <section id="projects">
        <h2>My Projects</h2>
        <p>Personal Portfolio and Student CRUD API</p>
      </section>

      <section id="contact">
        <h2>Contact Me</h2>
        <p>Email: your-email@example.com</p>
      </section>

      <footer>© 2026 My Portfolio</footer>
    </div>
  );
}

export default App;
