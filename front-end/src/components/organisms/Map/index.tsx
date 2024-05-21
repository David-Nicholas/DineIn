

import dynamic from 'next/dynamic';
import 'leaflet/dist/leaflet.css';

// Dynamically import the Map component with SSR disabled
const Map = dynamic(() => import('@/components/organisms/Map/Map'), {
  ssr: false, // Disable server-side rendering for this component
});

export default function Page() {
  return (
      <Map />
  );
}
