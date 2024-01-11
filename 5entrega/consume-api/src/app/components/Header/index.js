import Link from 'next/link'

export default function Header() {
	return (
		<header className="header">
			<img src="/logo.png" alt="logo" />
			<ul>
				<li>
					<Link href="/PrimeiraRota">Destinos</Link>
				</li>
				<li>
					<Link href="/SegundaRota">Link 2</Link>
				</li>
				<li>
					<Link href="/TerceiraRota">Link 3</Link>
				</li>
			</ul>
		</header>
	)
}
