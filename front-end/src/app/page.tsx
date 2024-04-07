import Image from "next/image";
import styles from "./page.module.css";
import CustomButton  from "@/components/CustomButton";



export default function Home() {
  return (
    <main>
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}>
      <div style={{ display: 'flex', gap: '20px' }}>
        <CustomButton text="View List" />
        <CustomButton text="View Map" />
      </div>
    </div>
    </main>
  );
}
