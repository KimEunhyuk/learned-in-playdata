import logo from './logo.svg';

// 1. Pure css 방식
// import './App.css';

// 2. SCSS 방식
//import './App.scss';

// 3. CSS Module 방식
import styles from './App.module.css';

// Button.js 컴포넌트 import
import Button from './components/Button';

function App() {
  console.log('App 실행');
  return (
    // 1. Pure css 방식
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>

    // 2. SCSS 방식 - npm install sass, import './App.scss';
  //   <div className="App">
  //   <header className="header">
  //     <img src={logo} className="logo" alt="logo" />
  //     <p>
  //       Edit <code>src/App.js</code> and save to reload.
  //     </p>
  //     <a
  //       className="link"
  //       href="https://reactjs.org"
  //       target="_blank"
  //       rel="noopener noreferrer"
  //     >
  //       Learn React
  //     </a>
  //   </header>
  // </div>
  // );

  // 3. CSS Module 방식 - App : 
  <div className={styles['App']}>
  <header className={styles['header']}>
    <img src={logo} className={styles['logo']} alt="logo" />
    <p>
      Edit <code>src/App.js</code> and save to reload.
    </p>
    <a
      className={styles['link']}
      href="https://reactjs.org"
      target="_blank"
      rel="noopener noreferrer"
    >
      Learn React
    </a>
    <Button />
  </header>


</div>
);
}

export default App;
