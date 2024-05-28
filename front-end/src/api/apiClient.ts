function getRequiredVariable(name: string): string {
    const value = process.env[name];
    if (!value) {
      throw new Error(`${name} env variable is missing`);
    }
    return value;
  }

export async function fetchData(route: string) {
    const urlFetch: string = getRequiredVariable('NEXT_PUBLIC_API_URL') + route    
    const res = await fetch(urlFetch, { cache: 'no-store' })
    // The return value is *not* serialized
    // You can return Date, Map, Set, etc.
   
    if (!res.ok) {
      // This will activate the closest `error.js` Error Boundary
      throw new Error('Failed to fetch data')
    }
   
    return res.json()
}