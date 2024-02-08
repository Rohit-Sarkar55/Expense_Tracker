const Navbar = () => {
    return (  
        <nav className="navbar">
            <h1>Kuber</h1>
            <div className="links">
                <a href="/">Home</a>
                <a href="/report" style={{
                    color: "white",
                    backgroundColor: "black",
                    borderRadius: "8px"
                }}>Report</a>
            </div>
        </nav>
    );
}
 
export default Navbar;