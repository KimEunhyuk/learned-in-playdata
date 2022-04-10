// button-style.css import
import './Button-style.css';

import styles from './Button.module.css';

// Button 컴포넌트.
const Button = props => {
    console.log(styles);
    return <button className={styles["error"]}>Check Button</button>
};

// 어딘가에서 Button.js 컴포넌트를 사용하기 위해서는
// 먼저 Button.js가 export(외부로 추출) 키워드를 사용해야함.

export default Button;